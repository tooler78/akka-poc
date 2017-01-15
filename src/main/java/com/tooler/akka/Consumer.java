package com.tooler.akka;

import akka.actor.UntypedActor;

/**
 * “Consumer” receives numbers and just print them
 */
public class Consumer extends UntypedActor {

    public void onReceive(final Object message) throws Throwable {
        if (message instanceof Integer) {
            System.out.println("<<< Received & printing " + message);
        }
    }
}
