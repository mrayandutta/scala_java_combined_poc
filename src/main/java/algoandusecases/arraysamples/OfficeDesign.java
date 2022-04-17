package algoandusecases.arraysamples;

import java.util.Arrays;

public class OfficeDesign {
	static int getMaxColors(int prices[], int money) {
		int count = 0, sum = 0;

		// sort the price array so only lower values are considered
		Arrays.sort(prices);
		for (int i = 0; i < prices.length; i++) {

			// Check if we can buy ith color or not
			if (sum + prices[i] <= money) {
				sum = sum + prices[i];
				// Increment count
				count++;
			}
		}
		return count;
	}

	// Driver Code
	public static void main(String[] args) {
		
		//int prices[] = { 1, 12, 5, 111, 200, 1000, 10, 9, 12, 15 };
		//int money = 50;
		int prices[] = { 2,3,5, 1, 1, 2, 1 };
		int money = 7;

		System.out.print(getMaxColors(prices, money));
	}

}
