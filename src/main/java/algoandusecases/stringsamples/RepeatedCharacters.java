package algoandusecases.stringsamples;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedCharacters {
	public static void main(String[] args) {
		String str = "FZABCDAAB";
		Map<Character, Long> result = str.chars().mapToObj(i->(char)i).map(x->Character.valueOf(x))
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		result
		.entrySet()
		.stream()
		.findFirst();
		//.map(x->{ System.out.println(x);return x;});
		//.filter(x->x.getValue()>1)
		//.forEach(x->System.out.println(x));
	}

}
