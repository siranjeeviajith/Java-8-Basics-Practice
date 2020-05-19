package com.MultiThreading;

public class RunnableExample implements Runnable {

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        Runnable runnable = new RunnableExample();

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();

        /* Runnable as Anonymous Class */
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
         runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside : " + Thread.currentThread().getName()+" ---Anonymous class");
            }
        };

        System.out.println("Creating Thread...");
         thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();

        //sleep operation

        System.out.println("Inside : " + Thread.currentThread().getName());

        String[] messages = {"If I can stop one heart from breaking,",
                "I shall not live in vain.",
                "If I can ease one life the aching,",
                "Or cool one pain,",
                "Or help one fainting robin",
                "Unto his nest again,",
                "I shall not live in vain"};

         runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());

            for(String message: messages) {
                System.out.println(message);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

         thread = new Thread(runnable);

        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
    }
}
