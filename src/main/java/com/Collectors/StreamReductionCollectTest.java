package com.Collectors;

import java.util.*;
import java.util.stream.Collectors;

public class StreamReductionCollectTest {

	public static void main(String[] args) {

		List<Product> productList = Arrays.asList(new Product(23, "potatoes",34F),
				new Product(14, "orange",56F), new Product(13, "lemon",11F),
				new Product(23, "bread",10F), new Product(13, "sugar",12F));
		
		//Dividing streams elements into groups according to some predicate
		Map<Boolean, List<Product>> collect = productList.stream().collect(Collectors.partitioningBy(p->p.getPrice()>15));
		collect.forEach((k,v)->{
			System.out.println(k);
			System.out.println(v);
		});
		
		System.out.println("---------------------------------------");
		//Pushing the collector to perform additional transformation
		Set<Product> collect2 = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		collect2.forEach(System.out::println);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void summaryStatisticsMethod(List<Product> productList) {
		DoubleSummaryStatistics collect = productList.stream().collect(Collectors.summarizingDouble(Product::getPrice));
		System.out.println(collect);
		System.out.println("------------------------");
		Map<Float, List<Product>> collect2 = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
		collect2.forEach((k,v)->{
			System.out.println(k);
			System.out.println(v);
		});
	}

	private static void method1(List<Product> productList) {
		//Converting stream to collection
		List<String> collect = productList.stream().map(Product::getName).collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		System.out.println("--------------------------------------------");
		
		//Reduce to String
		String collect2 = productList.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
		System.out.println(collect2);
		System.out.println("--------------------------------------------");
		//Average price 
		Double averagePrice = productList.stream().collect(Collectors.averagingDouble(Product::getPrice));
		System.out.println(averagePrice);
	}

}