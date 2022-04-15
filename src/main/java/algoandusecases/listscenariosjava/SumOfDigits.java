package algoandusecases.listscenariosjava;

public class SumOfDigits {
    public static void main(String[] args) {
        int digit = 9154;
        System.out.println(getSumOfDigits(digit));

    }
    public static int getSumOfDigits(int number)
    {
        int sum = 0;
        if(number < 10)
        {
            return number;
        }
        while(number>0)
        {
            int remainder =number % 10;
            sum = sum + remainder;
            number = (int)number/10;
        }
        return sum;
    }
}
