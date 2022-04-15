package javastreams.basic;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxCharCount {
	public static void main(String[] args) {
		
		String[] a ={"Hello Hi are you ","This is india"};
		List<String> list = Arrays.asList(a);
		//list.forEach(x->System.out.println(x));
		String delim = "";
        String strFromList = String.join(delim, list);
        char[] charactors = strFromList.toCharArray();
        //strFromList.chars().forEach(x->System.out.println((char)x));
        Map<Integer, Long> charactersMap =
        strFromList.chars().boxed().collect(Collectors.groupingBy(Function.identity(), 
                LinkedHashMap::new, 
                Collectors.counting()));
        System.out.println("characters:"+charactersMap);
        Optional<Entry<Integer, Long>> itemOptional = charactersMap.entrySet().stream().filter(e->e.getValue()==1).findFirst();
        Integer key = itemOptional.get().getKey();
        System.out.println((char)key.intValue());
        
		
		
	}

}
