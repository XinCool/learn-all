package com.akka.client.actor;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端：用于处理转换任务的Actor
 * 1.BACKEND_REGISTRATION：收到此消息说明有服务端通知客户端，TransformationFrontend首先将服务端的ActorRef加入backends列表，然后对服务端的ActorRef添加监管；
 * 2.Terminated：由于TransformationFrontend对服务端的ActorRef添加了监管，所以当服务端进程奔溃或者重启时，将收到Terminated消息，
 *      此时TransformationFrontend将此服务端的ActorRef从backends列表中移除；
 * 3.TransformationJob：此消息说明有新的转换任务需要TransformationFrontend处理，处理分两种情况：
 * backends列表为空，则向发送此任务的发送者返回JobFailed消息，并告知“目前没有服务端可用，请稍后再试”；
 * backends列表不为空，则通过取模运算选出一个服务端，将TransformationJob转发给服务端进一步处理；
 * @author Cool
 * @create 2020-11-02 15:11
 */
//@Named("TransformationFrontend")
@Scope("prototype")
public class TransformationFrontend extends UntypedActor {

    List<ActorRef> backends = new ArrayList<ActorRef>();
    int jobCounter = 0;

    @Override
    public void onReceive(Object message) {
        if ((message instanceof Integer) && backends.isEmpty()) {
            Integer msg = (Integer) message;
            getSender().tell(
                   msg,
                    getSender());

        } else if (message instanceof Integer) {
            Integer job = (Integer) message;
            jobCounter++;
            backends.get(jobCounter % backends.size())
                    .forward(job, getContext());

        } else if (message.equals("BACKEND_REGISTRATION")) {
            getContext().watch(getSender());
            backends.add(getSender());

        } else if (message instanceof Terminated) {
            Terminated terminated = (Terminated) message;
            backends.remove(terminated.getActor());

        } else {
            unhandled(message);
        }
    }

}
