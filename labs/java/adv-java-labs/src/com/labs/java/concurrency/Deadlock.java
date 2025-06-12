package com.labs.java.concurrency;

public class Deadlock implements Runnable {

    String me;
    Deadlock other;

    public void hello() {
        // The synchronized keyword is removed from here as we will handle
        // synchronization manually in the run() method.
        System.out.println(me + " says hello");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void init(String name, Deadlock friend) {
        me = name;
        other = friend;
    }

    public static void main(String args[]) {
        int wait = args.length == 0 ? 20 : Integer.parseInt(args[0]);

        Deadlock d1 = new Deadlock();
        Deadlock d2 = new Deadlock();

        d1.init("d1", d2);
        d2.init("d2", d1);

        Thread d1Thread = new Thread(d1);
        Thread d2Thread = new Thread(d2);

        d1Thread.start();
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
        }
        d2Thread.start();
    }

    // The synchronized keyword is removed from the method signature.
    public void run() {
        System.out.println("Starting thread " + me);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        // --- Deadlock Fix Starts Here ---
        Deadlock first, second;

        // Establish a consistent locking order based on hashCode.
        if (System.identityHashCode(this) < System.identityHashCode(other)) {
            first = this;
            second = other;
        } else {
            first = other;
            second = this;
        }

        System.out.println(me + " is trying to acquire locks...");
        // Acquire locks in the defined order.
        synchronized (first) {
            System.out.println(me + " acquired lock on " + first.me);
            try {
                Thread.sleep(100); // Added to make the lock acquisition clearer in output
            } catch(InterruptedException e) {}

            synchronized (second) {
                System.out.println(me + " acquired lock on " + second.me);
                System.out.println("Calling hello from " + me + " to " + other.me);
                other.hello();
            }
        }
        // --- Deadlock Fix Ends Here ---

        System.out.println("Ending thread " + me);
    }
}
