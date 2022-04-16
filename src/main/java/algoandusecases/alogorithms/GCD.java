package algoandusecases.alogorithms;

public class GCD {
    public static void main(String[] args) {
       // System.out.println("GCD :"+findGCD(3,10,0));
        //System.out.println("GCD :"+findGCD(5,10,0));
        System.out.println("GCD :"+findGCD(65,10,0));

    }
    public static int findGCD(int number1,int number2,int gcd)
    {
        if(gcd==1)
        {
            return gcd;
        }
        int firstNumber = number1;
        int secondNumber = number2;
        if(number1 < number2)
        {
            firstNumber = number2;
            secondNumber = number1;
        }
        //Start the process
        if(gcd==0)
            gcd = secondNumber;

        if(((firstNumber%gcd==0) && (secondNumber%gcd==0)))
        {
            return gcd;
        }
        else {

            gcd = findGCD(firstNumber, secondNumber, gcd-1);
        }
        return gcd;

    }
}
