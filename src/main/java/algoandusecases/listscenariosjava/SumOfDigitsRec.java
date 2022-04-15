package algoandusecases.listscenariosjava;

public class SumOfDigitsRec {
    public static int getSumOfDigits(int number,int sum)
    {
       if(number>0)
       {
           int remainder =number % 10;
           sum = sum + remainder;
           number = (int)number/10;
           return getSumOfDigits(number,sum);
       }
       else
       {
           return sum;
       }
    }
    public static int getSuperSum(int number)
    {
       int superSum = number;
       while(superSum >=10)
       {
           superSum=getSumOfDigits(superSum,0);
       }
       return superSum;
    }

    public static void main(String[] args) {
        int digit = 9154;
        System.out.println(getSumOfDigits(digit,0));
        System.out.println(getSuperSum(digit));
    }
}
