package com.example.akka.iiot.actors.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.example.akka.iiot.actors.ActorSystemContext;
import com.example.akka.iiot.actors.ClusterListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@Service
public class DefaultActorService implements ActorService {

    private static final String ACTOR_SYSTEM_NAME = "akka-cluster";

    @Resource
    private ActorSystemContext actorContext;

    private ActorSystem system;

    private ActorRef clusterListener;

    @PostConstruct
    public void initActorSystem() {
        actorContext.setActorService(this);
        system = ActorSystem.create(ACTOR_SYSTEM_NAME,actorContext.getConfig());
        actorContext.setActorSystem(system);

        //启动集群监听
        clusterListener = system.actorOf(Props.create(new ClusterListener.ActorCreator(actorContext)), "clusterListener");
        System.out.println(clusterListener);
    }

}
