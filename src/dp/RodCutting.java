package dp;

public class RodCutting {
	public int[] price;

	RodCutting(int[] p) {
		this.price = p;
	}

	public int rodCuttingTopDown(int dp[], int n) {
		if (n == 0)
			return 0;
		if (dp[n] > 0)
			return dp[n];
		int max = Integer.MIN_VALUE;
		// cur at every position from 1 to n
		for (int i = 1; i <= n; i++) {
			max = Integer.max(max, price[i] + rodCuttingTopDown(dp, n - i));
		}

		return dp[n] = max;
	}

	public int rodCuttingBottomUp(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 0; // base case
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				max = Integer.max(max, price[j] + dp[i - j]);
			}
			dp[i] = max;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int[] p = new int[] { 0, 1, 2, 3, 4, 13, 11, 13 };
		RodCutting rc = new RodCutting(p);
		int[] dp = new int[p.length];
		// Top down
		System.out.println(rc.rodCuttingTopDown(dp, 1));
		System.out.println(rc.rodCuttingTopDown(dp, 2));
		System.out.println(rc.rodCuttingTopDown(dp, 3));
		System.out.println(rc.rodCuttingTopDown(dp, 4));
		System.out.println(rc.rodCuttingTopDown(dp, 5));
		System.out.println(rc.rodCuttingTopDown(dp, 6));
		System.out.println(rc.rodCuttingTopDown(dp, 7));
		// Bottom up
		System.out.println();
		System.out.println(rc.rodCuttingBottomUp(1));
		System.out.println(rc.rodCuttingBottomUp(2));
		System.out.println(rc.rodCuttingBottomUp(3));
		System.out.println(rc.rodCuttingBottomUp(4));
		System.out.println(rc.rodCuttingBottomUp(5));
		System.out.println(rc.rodCuttingBottomUp(6));
		System.out.println(rc.rodCuttingBottomUp(7));

	}

}
