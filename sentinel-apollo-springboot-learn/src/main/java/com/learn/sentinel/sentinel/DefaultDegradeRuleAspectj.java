package com.learn.sentinel.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.util.MethodUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Description :用于给加了SentinelResource注解的资源增加默认熔断策略
 * 需要先于sentinel的切面执行
 * <p>
 * copy by cool on 2020/10/30 14:59
 */
@Aspect
@Component
@Order(1)
public class DefaultDegradeRuleAspectj {
    @Autowired
    private DefaultDegradeRule defaultDegradeRule;


    @Pointcut("@annotation(com.alibaba.csp.sentinel.annotation.SentinelResource)")
    public void sentinelResourceAnnotationPointcut() {
    }

    @Before("()")
    public void invokeResourceWithSentinel(JoinPoint joinPoint) throws Throwable {
        Method originMethod = resolveMethod(joinPoint);

        SentinelResource annotation = originMethod.getAnnotation(SentinelResource.class);
        if (annotation == null) {
            throw new IllegalStateException("Wrong state for SentinelResource annotation");
        }
        String resourceName = getResourceName(annotation.value(), originMethod);

        if (!DegradeRuleManager.hasConfig(resourceName)) {
            DegradeRule degradeRule = new DegradeRule();
            BeanUtils.copyProperties(defaultDegradeRule, degradeRule);
            degradeRule.setResource(resourceName);

            Set<DegradeRule> rules = new HashSet<>();
            rules.add(degradeRule);
            DegradeRuleManager.setRulesForResource(resourceName, rules);
        }

    }

    protected String getResourceName(String resourceName, Method method) {
        if (StringUtil.isNotBlank(resourceName)) {
            return resourceName;
        }
        return MethodUtil.resolveMethodName(method);
    }

    protected Method resolveMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Class<?> targetClass = joinPoint.getTarget().getClass();

        Method method = getDeclaredMethodFor(targetClass, signature.getName(),
                signature.getMethod().getParameterTypes());
        if (method == null) {
            throw new IllegalStateException("Cannot resolve target method: " + signature.getMethod().getName());
        }
        return method;
    }

    private Method getDeclaredMethodFor(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethodFor(superClass, name, parameterTypes);
            }
        }
        return null;
    }
}
