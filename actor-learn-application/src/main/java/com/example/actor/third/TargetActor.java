package com.example.actor.third;

import akka.actor.*;

import java.util.Optional;

/**
 * @author Cool
 * @create 2020-09-17 15:16
 */
class TargetActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Object.class, o -> {
            System.out.println("receive message:" + o);
        }).build();
    }
}


class LookupActor extends AbstractActor {
    private ActorRef actorRef = getContext().actorOf(Props.create(TargetActor.class), "targetActor");

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("system");
        ActorRef actor = actorSystem.actorOf(Props.create(LookupActor.class), "lookupActor");
        actor.tell("find", ActorRef.noSender());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, s -> {
            if ("find".equals(s)) {
                ActorSelection targetActor = getContext().actorSelection("targetActor");
                targetActor.tell(new Identify("001"), getSelf());
            }
        }).match(ActorIdentity.class, i -> {
            if (i.correlationId().equals("001")) {
                Optional<ActorRef> ref = i.getActorRef();
                if (ref != null) {
                    ActorRef actorRef = ref.get();
                    System.out.println("id:" + i.correlationId() + " " + actorRef);
                    actorRef.tell("hello targetActor", getSelf());
                }
            }
        }).build();
    }
}
