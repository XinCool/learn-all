package com.learn.sentinel.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description :默认熔断规则
 * <p>
 * Created by cool on 2020/10/30 14:44
 */
@Component
@Data
@ConfigurationProperties(prefix = "sentinel.degrade.default")
public class DefaultDegradeRule {
    private int grade = RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT;
    private double count = 3;
    private int timeWindow = 5;
    private int minRequestAmount = 3;
    private int statIntervalMs = 1000;
    private int rtSlowRequestAmount = RuleConstant.DEGRADE_DEFAULT_SLOW_REQUEST_AMOUNT;
}
