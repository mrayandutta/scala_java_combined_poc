package java8.fuctional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String args[]){
        Consumer<Integer> consumer1= i-> System.out.println("Number: "+i);
        Consumer<Integer> consumer2= i-> System.out.println("Multiplied Number: "+i*10);
        List<Integer> integerList=Arrays.asList(new Integer(1),
                new Integer(2), new Integer(3));
        printList(integerList, consumer1,consumer2);
    }
    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> c1,Consumer<Integer> c2){
        for(Integer number:listOfIntegers){
            c1.andThen(c2).accept(number);
        }
    }
}
