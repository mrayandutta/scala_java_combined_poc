package corejava.stringsamples;

import java.util.Comparator;

public class StringReverse {
	public static void main(String[] args) {
		String str = "ABCD";
		str.chars().mapToObj(i-> Character.valueOf((char)i))//.forEach(x->System.out.println(x));
		.sorted(Comparator.comparing(Character::valueOf).reversed())
		.forEach(x->System.out.println(x));
		
		int counter = str.length() - 1;
		for (int i = counter; i >= str.length(); i--) {
			System.out.println(str.charAt(i));
			
		}
	}

}
