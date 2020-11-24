package com.example.akka.iiot.actors;


import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.example.akka.iiot.actors.service.ContextBasedCreator;

/**
 * @Author: COOL
 * @Date: Created in 2020/10/27 15:57
 * @Description: 集群监成员听器
 */
public class ClusterListener extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private final Cluster cluster = Cluster.get(getContext().system());
    private final ActorSystemContext systemContext;

    private ClusterListener(ActorSystemContext systemContext) {
        this.systemContext = systemContext;
    }

    @Override
    public void preStart() {
        // #subscribe
        cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(), ClusterEvent.MemberEvent.class, ClusterEvent.UnreachableMember.class);
        // #subscribe
    }

    @Override
    public void postStop() {
        cluster.unsubscribe(getSelf());
    }

    @Override
    public void onReceive(Object message) {
        if (message instanceof ClusterEvent.MemberUp) {
            ClusterEvent.MemberUp mUp = (ClusterEvent.MemberUp) message;
            log.info("Member is Up: {}", mUp.member());
        } else if (message instanceof ClusterEvent.UnreachableMember) {
            ClusterEvent.UnreachableMember mUnreachable = (ClusterEvent.UnreachableMember) message;
            log.info("Member detected as unreachable: {}", mUnreachable.member());
        } else if (message instanceof ClusterEvent.MemberRemoved) {
            ClusterEvent.MemberRemoved mRemoved = (ClusterEvent.MemberRemoved) message;
            log.info("Member is Removed: {}", mRemoved.member());
        } else if (message instanceof ClusterEvent.MemberEvent) {
            // ignore
        } else {
            unhandled(message);
        }
    }

    public static class ActorCreator extends ContextBasedCreator<ClusterListener> {

        private static final long serialVersionUID = 1L;

        public ActorCreator(ActorSystemContext context) {
            super(context);
        }

        @Override
        public ClusterListener create() {
            return new ClusterListener(context);
        }
    }

}
