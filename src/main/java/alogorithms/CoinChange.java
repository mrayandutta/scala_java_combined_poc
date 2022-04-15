package alogorithms;

public class CoinChange {
	public static void main(String[] args) {
		int[] currencies = { 2, 3, 4 };
		int amount = 10;
		
		System.out.println(
		        "Number of ways we can pay using given currencies are : " + 
		                             coinchange(0, amount, currencies, ""));
	}

	// https://java2blog.com/coin-change-problem-java/

	public static int coinchange(int ci, int remaining, int[] currencies, String paid) {
		if (remaining == 0) {
			/*
			 * this means the amount to be paid can be paid using only the given currencies.
			 */
			System.out.println(paid);
			/*
			 * as this is one of the way to pay, hence it will contribute +1 number of ways
			 * for itself
			 */
			return 1;
		}
		if (remaining < 0) {
			/*
			 * if the remaining amount to be paid is negative, this means that the set of
			 * coins we've paid does not add upto the amount to be paid, hence it is not one
			 * of the way to pay.
			 */
			return 0;
		}

		int res = 0;
		for (int i = ci; i < currencies.length; i++) {

			/*
			 * we must start our loop from current index, as if we loop through all
			 * currencies once again then there will be a repetition in the ways used to pay
			 * the amount.
			 */
			res += coinchange(i, remaining - currencies[i], currencies, paid + Integer.toString(currencies[i]) + ", ");

		}

		return res;

	}

}
