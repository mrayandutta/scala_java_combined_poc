package algoandusecases.arraysamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondHighestItem {
    public static void main(String[] args) {
        Integer [] numbers ={1,2,6,3,0,78,23,-6,12};
        Optional secondHighestItem  = Arrays.stream(numbers).sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
                //.forEach(x-> System.out.println(x));
        System.out.println("Second highest item:"+secondHighestItem.get());
    }
}
