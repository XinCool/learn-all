package com.example.actor.first;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * ActorRef给ActorDemo发送消息
 * ActorDemo接收到消息
 * @author Cool
 * @create 2020-09-17 14:24
 */
public class ActorDemo extends AbstractActor {

    private final LoggingAdapter logger = Logging.getLogger(getContext().getSystem(), this);

    @Override

    public Receive createReceive() {

        return receiveBuilder().match(String.class, s -> {

            logger.info("小明：" + s+"\ngetSender():"+getSender()+"\ngetSelf():"+getSelf());

        }).matchAny(other -> {

            logger.info("其它未知消息：" + other);

        }).build();

    }


    public static void main(String[] args) {
        //创建了一个Actor系统，并起名为system：
        ActorSystem system = ActorSystem.create("system");
        //ActorSystem的actorOf()方法创建了一个名为actorDemo的Actor：
        ActorRef demo = system.actorOf(Props.create(ActorDemo.class), "actorDemo");
        //第一个参数表示消息，它可以接受任何类型的数据，第二个参数表示发送者，也就是另外一个actor的引用对象。
        // 使用的ActorRef.noSender()，表示没有发送者（其实是一个叫做deadLetters的Actor）
        //如果我们想得到发送者，可以调用getSender()方法。
        //通过ActorRef的tell()方法给actorDemo发了一个消息.第一个参数是消息，第二个参数是发送者
        demo.tell("hello world",ActorRef.noSender());

        final Integer other=20;
        //通过ActorRef的tell()方法给actorDemo发了一个消息，也就是给actorDemo邮箱发了一条信息就返回了
        //第一个参数是消息，第二个参数是发送者
        demo.tell(other,ActorRef.noSender());


        //****生命周期----停止3种方法****
        //第一种：ActorSystem停止actor
        //system.stop(demo);
        //第二种
        //demo.tell(PoisonPill.getInstance(),ActorRef.noSender());
        //第三种
        //demo.tell(Kill.getInstance(),ActorRef.noSender());
        //
        //



    }

    @Override
    public void postStop() throws Exception {
        logger.info("actor stop");
    }



}

