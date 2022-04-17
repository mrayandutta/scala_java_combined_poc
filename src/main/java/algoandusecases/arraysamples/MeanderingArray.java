package algoandusecases.arraysamples;

import java.util.Arrays;
import java.util.Collections;

/**
 * An array of integers is defined as being meandering order when the first two elements are
 * the respective largest and smallest elements in the array and the subsequent elements
 * alternate between its next largest and next smallest elements.
 */
public class MeanderingArray {
	public static void main(String[] args) {
		Integer[] numberArray = {-1, 3, 4, 6, -5};
		Integer[] outputArray = new Integer[numberArray.length];
		Arrays.sort(numberArray,Collections.reverseOrder());
		int newIndex = 0;
		System.out.println("Array after sort ::");
		for (int i = 0; i < numberArray.length; i++) {
			System.out.print(numberArray[i]);
		}
		
		/*
		int midIndex = numberArray.length /2;
		for (int i = 0; i < midIndex; i++) {
			int higherValue = numberArray[i];
			int lowerValue = numberArray[numberArray.length -1 - i];
			outputArray[newIndex]=higherValue;
			newIndex++;
			outputArray[newIndex] = lowerValue;
			newIndex++;
			
		}
		*/
		int lastIndex = numberArray.length -1;
		int k =0;
		for (int i = 0; i < numberArray.length; i++) {
			int highestNumber = numberArray[i];
			int lowestNumber = numberArray[lastIndex - i];
			if(highestNumber == lowestNumber)
			{
				outputArray[k]=highestNumber;
				break;
			}
				
			outputArray[k]=highestNumber;
			k++;
			outputArray[k] = lowestNumber;
			k++;
			System.out.println("\n highestNumber:"+highestNumber+","+"lowestNumber:"+lowestNumber);
			
			
		}
		
		System.out.println("Output::::::::::::");
		for (int i = 0; i < outputArray.length; i++) {
			System.out.println(outputArray[i]);
		}
		
	}

}
