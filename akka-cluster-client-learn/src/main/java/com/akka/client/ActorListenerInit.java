package com.akka.client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.akka.client.actor.TransformationBackend;
import com.akka.client.actor.TransformationFrontend;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Cool
 * @create 2020-11-02 15:20
 */
@Service
public class ActorListenerInit {
    private static final String ACTOR_SYSTEM_NAME = "akka-cluster";
    private static final Config config = ConfigFactory.parseResources("actor-system.conf").withFallback(ConfigFactory.load());


    private ActorSystem system;

    private ActorRef clusterListener;

    private ActorRef remoteReceiveActor;

    private ActorRef clusterReceiveActor;

    @PostConstruct
    public void initActorSystem() {
        system = ActorSystem.create(ACTOR_SYSTEM_NAME,config);

        /**
         * 以下为测试使用代码
         */
        remoteReceiveActor = system.actorOf(Props.create(TransformationBackend.class), "transformationBackend");
        clusterReceiveActor = system.actorOf(Props.create(TransformationFrontend.class), "transformationFrontend");
    }
}
