package algoandusecases.listscenariosjava;

import java.util.Arrays;
import java.util.List;

public class SortWithJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,3,25,12);
        System.out.println("Input:"+numbers);
        int listSize = numbers.size();
        /*
        for (int i= 0;i< listSize;i++)
        {
            for(int j= 0;j<=i;j++)
            {
                if(j< listSize-1)
                {
                    int firstItem = numbers.get(j);
                    int secondItem = numbers.get(j+1);
                    if(firstItem>secondItem)
                    {
                        numbers.set(j,secondItem);
                        numbers.set(j+1,firstItem);

                    }
                }

            }

        }
        */
         sortList(numbers,listSize);
        System.out.println("Output:"+numbers);
    }

    public static void sortList(List<Integer> numbers,int n)
    {
        if(n==1)
            return;
        for (int i= 0;i< n;i++)
        {
            for(int j= 0;j<=i;j++)
            {
                if(j< n-1)
                {
                    int firstItem = numbers.get(j);
                    int secondItem = numbers.get(j+1);
                    if(firstItem>secondItem)
                    {
                        numbers.set(j,secondItem);
                        numbers.set(j+1,firstItem);

                    }
                }

            }

        }
        sortList(numbers,n-1);

    }
}
