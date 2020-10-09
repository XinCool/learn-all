package com.example.akka.config;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;

/**
 * @author Cool
 * @create 2020-09-17 17:04
 * 过继承AbstractExtensionId，我们可以在ActorSystem范围内创建并查找SpringExt
 */

public class SpringExtProvider extends AbstractExtensionId<SpringExt> {
    private static SpringExtProvider provider = new SpringExtProvider();

    public static SpringExtProvider getInstance() {
        return provider;
    }

    @Override
    public SpringExt createExtension(ExtendedActorSystem extendedActorSystem) {
        return new SpringExt();
    }
}

