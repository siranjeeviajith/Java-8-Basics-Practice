package com.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingExample {
    public static void main(String[] args){
       /*Handling EXception using Exceptionally method*/
        ///will throw exception,. str is null
        System.out.println("Handling EXception using exceptionally method");
        String str = null;
        CompletableFuture<String> value = CompletableFuture.supplyAsync(() -> {
            if (str == null)
                throw new IllegalArgumentException("Invalid String value passed " + str);
            return str;
        }).exceptionally(exp -> {
            System.out.println("Exception thrown with message - " + exp.getMessage());
            return "";
        });


        ///str has a value ,, execute as normal
        String str1 = "hello ajith";
        CompletableFuture<String> value1 = CompletableFuture.supplyAsync(() -> {
            if (str1 == null)
                throw new IllegalArgumentException("Invalid String value passed " + str1);
            return str1;
        }).exceptionally(exp -> {
            System.out.println("Exception thrown with message - " + exp.getMessage());
            return "";
        });
        value1.thenAccept(System.out::println);


        System.out.println("Handling EXception using handle method");
        /*Handling EXception using handle method*/
        ///will throw exception,. str is null
        CompletableFuture<String> value2 = CompletableFuture.supplyAsync(() -> {
            if (str == null)
                throw new IllegalArgumentException("Invalid String value passed " + str);
            return str;
        }).handle((s, exp) -> {
            if(exp != null) {
                System.out.println("Exception thrown with message - " + exp.getMessage());
                s = "";
            }
            return s;
        });

        ///str has a value ,, even though handle is called and execute as normal
        CompletableFuture<String> value3 = CompletableFuture.supplyAsync(() -> {
            if (str1 == null)
                throw new IllegalArgumentException("Invalid String value passed " + str1);
            return str1;
        }).handle((s, exp) -> {
            System.out.println("In handle method..");
            if(exp != null) {
                System.out.println("Exception thrown with message - " + exp.getMessage());
                s = "";
            }
            return s;
        });
        value3.thenAccept(System.out::println);

        /*Handling EXception using whenComplete method*/
        ///will throw exception,. str is null
        CompletableFuture<String> value4 = CompletableFuture.supplyAsync(() -> {
            if (str == null)
                throw new IllegalArgumentException("Invalid String value passed " + str);
            return str;
        }).whenComplete((s, exp) -> {
            System.out.println("in whenComplete method");
            if(exp != null) {
                System.out.println("Exception thrown with message - " + exp.getMessage());
                //s = "";
            }
        });
    }


}
