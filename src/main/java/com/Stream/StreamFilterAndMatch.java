package com.Stream;

import com.lambdaExpression.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilterAndMatch {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Llewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        Stream<Person> filteredList = people.stream().filter(s->s.getAge()>25);
        filteredList.forEach(System.out::println);

        System.out.println("-------------------");

        boolean allMatch = people.stream().allMatch(s->s.getFirstName().contains("l"));
        System.out.println(allMatch);

        System.out.println("-------------------");
        boolean anyMatch = people.stream().anyMatch(s->s.getAge()>35);
        System.out.println(anyMatch);
        System.out.println("-------------------");
        boolean noneMatch = people.stream().noneMatch(s->s.getAge()>55);
        System.out.println(noneMatch);
    }
}
