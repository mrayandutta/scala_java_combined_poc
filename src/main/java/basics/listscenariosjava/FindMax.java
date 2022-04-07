package basics.listscenariosjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMax {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        int max = Collections.max(numbers);
        System.out.println(max);


    }

}
