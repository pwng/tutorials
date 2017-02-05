package com.ngpanwei.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SampleList {

	public static void main(String args[]) {
		List<Integer> numbers = Arrays.asList(1,2,3) ;
		
		for(Integer i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i)) ;
		}
		for(Integer value : numbers) {
			System.out.println(value) ;
		}
		numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value) ;
			}
		});
		numbers.forEach((Integer value) -> System.out.println(value)) ;
		
		numbers.forEach((value) -> System.out.println(value)) ;

		numbers.forEach(value -> System.out.println(value)) ;

		numbers.forEach(System.out::println) ;
		
	}
}
