package com.tooler.akka;

import akka.actor.*;
import scala.concurrent.Future;

import java.util.concurrent.TimeUnit;

/**
 * “Producer” creates numbers from 1 to 10,
 */
public class Producer {

    public static void main(final String[] arguments) throws InterruptedException {
        final ActorSystem system = ActorSystem.create("generate-numbers-one-to-ten");
        final ActorRef printNumbersConsumer = system.actorOf(Props.create(Consumer.class));

        for (int i = 1; i <= 10; i++) {
            System.out.println(">>> Producing and sending a number " + i);
            printNumbersConsumer.tell(i, ActorRef.noSender());
            TimeUnit.MILLISECONDS.sleep(10);
        }

        final Future<Terminated> future = system.terminate();
        System.out.println("===== Finished producing & sending numbers 1 to 10");
    }
}
