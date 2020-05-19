package com.FutureAndCallable;

import java.util.concurrent.Callable;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Perform some computation
                Thread.sleep(2000);
                return "Return some result from Anonymous class";
            }
        };
        System.out.println(callable.call());

         callable = () -> {
            // Perform some computation
            Thread.sleep(2000);
            return "Return some result using Lambda Expression";
        };

        System.out.println(callable.call());
    }
}
