package com.akka.client;

/**
 * @author Cool
 * @create 2020-11-02 15:20
 */
@Service
public class ActorListenerInit {
    private static final String ACTOR_SYSTEM_NAME = "akka-cluster";

    @Resource
    private ActorSystemContext actorContext;

    private ActorSystem system;

    private ActorRef clusterListener;

    private ActorRef remoteReceiveActor;

    private ActorRef clusterReceiveActor;

    @PostConstruct
    public void initActorSystem() {
        actorContext.setActorService(this);
        system = ActorSystem.create(ACTOR_SYSTEM_NAME,actorContext.getConfig());
        actorContext.setActorSystem(system);

        //启动集群监听
        clusterListener = system.actorOf(Props.create(new ClusterListener.ActorCreator(actorContext)), "clusterListener");
        actorContext.setClusterListener(clusterListener);




        /**
         * 以下为测试使用代码
         */
        remoteReceiveActor = system.actorOf(Props.create(RemoteReceiveActor.class), "remoteReceiveActor");
        clusterReceiveActor = system.actorOf(Props.create(ClusterReceiveActor.class), "clusterReceiveActor");
    }
}
