package com.example.akka.iiot.actors;

import akka.actor.ActorSystem;
import com.example.akka.iiot.actors.service.ActorService;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;



@Component
public class ActorSystemContext {

    private static final String AKKA_CONF_FILE_NAME = "actor-system.conf";

    @Getter
    @Setter
    private ActorService actorService;

    @Getter
    @Setter
    private ActorSystem actorSystem;

    @Getter
    private final Config config;

    public ActorSystemContext() {
        config = ConfigFactory.parseResources(AKKA_CONF_FILE_NAME).withFallback(ConfigFactory.load());
    }

}
