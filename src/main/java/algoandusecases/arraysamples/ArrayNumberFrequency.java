package algoandusecases.arraysamples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayNumberFrequency {
	public static void main(String[] args) {
		Integer[] numberArray = {-1, 2,2,3,3, 4,4,4, 6, -5};
		Arrays.asList(numberArray).stream()
		//.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.collect(Collectors.partitioningBy(x->Integer.valueOf(x)%2==0))
		.entrySet()
		.stream()
		//.filter(x->x.getValue()>1)
		//.sorted(Comparator.comparing(Map.Entry::getValue))
		//.forEach((k,v)->System.out.println("key:"+k+",value:"+v));
		.forEach(x->System.out.println("key:"+x));
	}

}
