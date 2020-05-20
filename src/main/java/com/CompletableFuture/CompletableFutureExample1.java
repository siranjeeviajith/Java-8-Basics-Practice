package com.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample1 {
    public static String compute(){
        try {
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println(e);
            }
        return "Hi displayed after sleep";
    }
    public static CompletableFuture<String> create(){
        return new CompletableFuture<>().supplyAsync(()->"Hello!");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = new CompletableFuture<>();

//        String value = cf.get();
//        System.out.println(value); // get block the execution until the Future completes.

        System.out.println("Before Completable Future!!");
        CompletableFuture<String> complete= CompletableFuture.supplyAsync(CompletableFutureExample1::compute);
        complete.thenAccept(System.out::println); // dont get blocked or wait until for task completion...

        System.out.println("After Completable Future!!!");


        Thread.sleep(3000);

        CompletableFuture<String> future= create();
        future.thenAccept(System.out::println);

        future= create()
                .thenApply((s)->s+"_world!");
        future.thenAccept(System.out::println);

       //Chaining more than CompletableFuture
        create().thenApply((s)->s.toLowerCase())
                .thenApply((s)->s.replace('!',' '))
                .thenApply((s)->s+"world!!!")
                .thenApply((s)->s.toUpperCase())
                .thenAccept(System.out::println)
                .thenCompose((x)->{System.out.println(x); return CompletableFuture.supplyAsync(()->"chaining the second Future");})
                .thenAccept(System.out::println)
                .thenCompose((x)->CompletableFuture.supplyAsync(()->"chaining the third Future"))
                .thenAccept(System.out::println);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Combining two CompletableFutures";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "and getting a new CompletableFuture";
        });

        CompletableFuture<String> result = future1.thenCombine(future2, (str1, str2) -> str1 + " " + str2);
        System.out.println("Value- " + result.get());

    }
}
