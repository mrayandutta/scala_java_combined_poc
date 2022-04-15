package javastreams.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,5};
		List<Integer> numberList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		Integer max = Collections.max(numberList);
		Integer min = Collections.min(numberList);
		//Integer sum = numberList.stream().reduce(0,(a,b)->a+b);
		Integer sum = numberList.stream()
				  .collect(Collectors.summingInt(Integer::intValue));
		System.out.println("max:"+max);
		System.out.println("min:"+min);
		System.out.println("sum:"+sum);
		Integer sumWithoutMissingNumber = (5*6)/2;
		System.out.println("sumWithoutMissingNumber:"+sumWithoutMissingNumber);
		System.out.println("Missing Number:"+(sumWithoutMissingNumber-sum));
		
		
	}

}
