package com.Collectors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

public class StreamReductionTest {

	public static void main(String[] args) {
		List<Product> productList = Arrays.asList(new Product(23, "potatoes",34F),
				new Product(14, "orange",56F), new Product(13, "lemon",11F),
				new Product(23, "bread",10F), new Product(13, "sugar",12F));
		//Custom collector
		Collector<Product, ?, LinkedList<Product>> toLinkedList =
				Collector.of(LinkedList::new, LinkedList::add,(first, second) -> { first.addAll(second);return first;});

		LinkedList<Product> linkedListOfPersons = productList.stream().collect(toLinkedList);
		linkedListOfPersons.forEach(System.out::println);

	}

}
