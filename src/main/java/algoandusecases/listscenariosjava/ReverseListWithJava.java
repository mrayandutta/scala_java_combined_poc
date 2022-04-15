package algoandusecases.listscenariosjava;

import java.util.Arrays;
import java.util.List;

public class ReverseListWithJava {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10,20,3,25,12);
        System.out.println("Input:"+numbers);
        numbers = sortRec(numbers,0);
        System.out.println("Output:"+numbers);

    }

    public static List<Integer> sortRec(List<Integer> numbers,int counter)
    {
        int size = numbers.size();
        if(counter>= size / 2 )
            return numbers;
        int firstItem = numbers.get(counter);
        int lastItem = numbers.get(numbers.size()-1- counter);
        numbers.set(counter,lastItem);
        numbers.set(numbers.size()-1- counter,firstItem);
        return sortRec(numbers,counter +1);
    }
}
