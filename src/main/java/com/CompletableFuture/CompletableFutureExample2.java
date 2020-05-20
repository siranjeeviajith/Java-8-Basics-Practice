package com.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureExample2 {
    public static void main(String[] args) {
        CompletableFutureExample2 completableFutureExample2 = new CompletableFutureExample2();
        try {
            // blocking call
            completableFutureExample2.getUsers();
        } catch (ExecutionException | InterruptedException e) {

            e.printStackTrace();
        }
    }

    public void getUsers() throws ExecutionException, InterruptedException{
        CompletableFuture<List<User>> userList = CompletableFuture.supplyAsync(() -> {
            return getListOfUsers();
        }).thenCompose(users-> {
            List<User> upperCaseList = null;
            try {
                upperCaseList = users.get().stream().map(
                        user->{
                            user.setFirstName(user.getFirstName().toUpperCase());
                            user.setLastName(user.getLastName().toUpperCase());
                            return user;
                        }).collect(Collectors.toList());
            } catch (InterruptedException | ExecutionException e) {

                e.printStackTrace();
            }
            return CompletableFuture.completedFuture(upperCaseList);
        });

        userList.get().forEach(System.out::println);
    }

    // Method for adding List of Users
    private CompletableFuture<List<User>> getListOfUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Jack", "Reacher", 15,"abc@xyz.com"));
        users.add(new User("Remington", "Steele",25, "rs@cbd.com"));
        users.add(new User("Laura", "Holt", 34,"lh@cbd.com"));
        users.add(new User("Jonathan", "Raven", 48,"jr@sn.com"));
        users.add(new User("Tom", "Hanson",26, "th@jd.com"));
        users.add(new User("Alexander", "Scott",32, "as@is.com"));
        users.add(new User("Jim", "Phelps", 44,"jp@mi.com"));
        return CompletableFuture.completedFuture(users);
    }
}

