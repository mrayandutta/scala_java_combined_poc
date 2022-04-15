package javastreams.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {
	public static void main(String[] args) {
		String str = "Hi This is India and India is great";
		String[] wordArray = str.split(" ");
		//System.out.println(""+wordArray);
		//Arrays.stream(wordArray).forEach(x->System.out.println(x));
		Map<String, Long> wordMap = Arrays.stream(wordArray).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(wordMap);
		Entry<String, Long> maxCountWord = wordMap.entrySet().stream().max(Comparator.comparing(Entry:: getValue)).get();
		System.out.println("maxCountWord:"+maxCountWord);
				
	}
}
