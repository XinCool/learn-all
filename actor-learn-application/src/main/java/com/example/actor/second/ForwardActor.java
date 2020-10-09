package com.example.actor.second;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 消息转发
 * 1. ActorRef给forwardActor发送消息
 * 2. forwardActor收到消息后转发给targetActor
 * 3. targetActor接收到消息
 * @author Cool
 * @create 2020-09-17 14:24
 */
public class ForwardActor extends AbstractActor {
    private ActorRef actorRef = getContext().actorOf(Props.create(TargetActor.class), "targetActor");

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create();
        ActorRef forwardActor = actorSystem.actorOf(Props.create(ForwardActor.class), "forwardActor");
        forwardActor.tell("hello world", ActorRef.noSender());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, s -> {
            System.out.println("forwardActor recieve message:" + s);
            actorRef.forward(s, getContext());
            System.out.println("forwardActor forward message to targetActor" );
        }).build();
    }
}

class TargetActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, s -> {
            System.out.println("targetActor recieve forward message:" + s);
        }).build();
    }
}

