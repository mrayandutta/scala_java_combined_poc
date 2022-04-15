package javastreams.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class ListSort {
	public static void main(String[] args) {
		Integer [] numbers = {1,23,5,32};
		Arrays.asList(numbers).stream().sorted(Comparator.comparing(Function.identity())).forEach(x->System.out.println(x));
	}

}
