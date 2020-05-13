package com.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReference {
    public static void main(String[] args) {

		/*Stream<String> stream = Stream.of("a","b","c").filter(e->e.contains("b"));
		Optional<String> findAny = stream.findAny();
		System.out.println(findAny.get());
		Optional<String> findFirst = stream.findFirst();*/ // throw error

        List<String> collect = Stream.of("a","b","c").filter(e->e.contains("b")).collect(Collectors.toList());


        Optional<String> findAny = collect.stream().findAny();
        System.out.println(findAny.get());

        Optional<String> findFirst = collect.stream().findFirst();
        System.out.println(findFirst.get());


        Stream<String> onceModifiedStream =Stream.of("abcd", "bbcd", "cbcd").skip(1);
        onceModifiedStream.forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        Stream<String> stream =Stream.of("abc1", "bcd2", "xyz3");
        Stream<String> twiceModifiedStream =stream.skip(1).map(element -> element.substring(0, 3));
        twiceModifiedStream.forEach(System.out::println);

        System.out.println("------------------------------------------------------");
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
        System.out.println(size);

    }
}
