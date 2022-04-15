package corejava;

public class NumberPalindrome {
	
	public static void main(String[] args) {
		int input = 121;
		int number = input;
		
		int sum =0;
		int r = 0;
		while(number > 10) 
		{
			r = number % 10;
			sum = sum * 10 +r;
			number = (number)/10;
			System.out.println(sum);
			
		}
		sum = sum * 10 +number;
		System.out.println(sum);
		
	}

}
