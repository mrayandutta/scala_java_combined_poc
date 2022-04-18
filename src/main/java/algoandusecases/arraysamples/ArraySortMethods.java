package algoandusecases.arraysamples;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortMethods {
    public static void main(String[] args) {
        Integer[] numbers = {2,1,3};
        //Arrays.sort(numbers);
        System.out.println("sorted array :");
        //Arrays.asList(numbers).stream().forEach(item-> System.out.println(item));
        Integer[] sortedNumbers = Arrays.asList(numbers).stream()
                .sorted()
                .toArray(Integer[]::new );
                //.forEach(item-> System.out.println(item)).;
        Arrays.asList(sortedNumbers).stream().forEach(item-> System.out.println(item));
    }
}
