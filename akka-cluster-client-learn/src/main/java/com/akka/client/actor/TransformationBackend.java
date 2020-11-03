package com.akka.client.actor;

import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.Member;
import akka.cluster.MemberStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

/**
 * 服务端：接收actor
 * TransformationBackend在preStart方法中订阅了集群的MemberUp事件，这样当它发现新注册的集群成员节点的角色是frontend（前端）时，
 * 将向此节点发送BACKEND_REGISTRATION消息，后者将会知道前者提供了服务。TransformationBackend所在的节点在刚刚加入集群时，
 * TransformationBackend还会收到CurrentClusterState消息，从中可以解析出集群中的所有前端节点（即roles为frontend的），
 * 并向其发送BACKEND_REGISTRATION消息。经过以上两步可以确保集群中的前端节点和后端节点无论启动或加入集群的顺序怎样变化，
 * 都不会影响后端节点通知所有的前端节点及前端节点知道哪些后端节点提供了服务
 *
 * @author Cool
 * @create 2020-11-02 15:08
 */
//@Named("TransformationBackend")
@Scope("prototype")
public class TransformationBackend extends UntypedActor {

    private static Logger logger = LoggerFactory.getLogger(TransformationBackend.class);

    Cluster cluster = Cluster.get(getContext().system());

    // subscribe to cluster changes, MemberUp
    @Override
    public void preStart() {
        cluster.subscribe(getSelf(), ClusterEvent.MemberUp.class);
    }

    // re-subscribe when restart
    @Override
    public void postStop() {
        cluster.unsubscribe(getSelf());
    }

    @Override
    public void onReceive(Object message) {
        if (message instanceof Integer) {
            Integer job = (Integer) message;
            logger.info(job+"");
            getSender().tell(message, getSelf());

        } else if (message instanceof ClusterEvent.CurrentClusterState) {
            ClusterEvent.CurrentClusterState state = (ClusterEvent.CurrentClusterState) message;
            for (Member member : state.getMembers()) {
                if (member.status().equals(MemberStatus.up())) {
                    register(member);
                }
            }

        } else if (message instanceof ClusterEvent.MemberUp) {
            ClusterEvent.MemberUp mUp = (ClusterEvent.MemberUp) message;
            register(mUp.member());

        } else {
            unhandled(message);
        }
    }

    void register(Member member) {
        if (member.hasRole("frontend"))
            getContext().actorSelection(member.address() + "/user/transformationFrontend").tell("BACKEND_REGISTRATION", getSelf());
    }
}