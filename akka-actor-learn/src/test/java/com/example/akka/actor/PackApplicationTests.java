package com.example.akka.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.example.akka.config.SpringExtProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Cool
 * @create 2020-09-17 17:06
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class PackApplicationTests {

    @Autowired
    private ActorSystem actorSystem;

    @Test
    public void contextLoads() {
        ActorRef ref = actorSystem.actorOf(SpringExtProvider.getInstance().get(actorSystem).create("testActor"), "testActor");
        ref.tell("hello",ActorRef.noSender());
    }
}

