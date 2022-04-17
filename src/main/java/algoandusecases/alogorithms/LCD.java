package algoandusecases.alogorithms;

public class LCD {
    public static void main(String[] args) {
        System.out.println("lcd :"+findLCD(3,10,0));
        System.out.println("lcd :"+findLCD(5,10,0));
        System.out.println("lcd :"+findLCD(65,10,0));
        System.out.println("lcd :"+findLCD(14,77,0));

    }
    public static int findLCD(int number1,int number2,int lcd)
    {

        int firstNumber = number1;
        int secondNumber = number2;
        if(number1 < number2)
        {
            firstNumber = number2;
            secondNumber = number1;
        }
        if(lcd==0)
        {
            lcd = firstNumber;
        }

        if(((lcd%firstNumber==0) && (lcd%secondNumber==0)))
        {
            return lcd;
        }
        else {

            lcd = findLCD(firstNumber, secondNumber, lcd+1);
        }
        return lcd;

    }
}
