package com.Stream;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInfinite {
    public static void main(String[] args) {

        Stream<Integer> iterate = Stream.iterate(0, i->i+2);
        List<Integer> collect = iterate.limit(10).collect(Collectors.toList());
        collect.forEach(System.out::println);



        Supplier<UUID> randomUUIDs = UUID::randomUUID;
        Stream<UUID> generate = Stream.generate(randomUUIDs);

        List<UUID> collect1 = generate.skip(10).limit(10).collect(Collectors.toList());

        collect1.forEach(System.out::println);

        System.out.println("-----------------------------");

        Stream<Integer> iterate1 = Stream.iterate(0, i->i+1);
        iterate1.limit(10).forEach(System.out::println);

    }
}
