package basics.listscenariosjava;

import java.util.Arrays;
import java.util.List;

public class MaxMinRecursionJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);

        int max = numbers.get(0);
        int result = findMax(numbers,max) ;
        System.out.println(result);

    }

     public static int findMax(List<Integer> numbers, Integer max) {
        //System.out.println("list size "+numbers.size());
        if (numbers.isEmpty()) {
            return max;
        } else
        {
            Integer firstItem = numbers.get(0);
            if(firstItem > max)
                max = firstItem;
            return findMax(numbers.subList(1,numbers.size()),max);
    }
    }
}
