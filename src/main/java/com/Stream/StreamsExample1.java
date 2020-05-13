package com.Stream;

import com.lambdaExpression.Person;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {

	public static void main(String[] args) throws IOException {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);



		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));
		



		long count = people.parallelStream()
		.filter(p -> p.getLastName().startsWith("D"))
		.count();
		
		System.out.println(count);
		

	}

}
