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

	public int rodCuttingBottomUp(int n, int[] firstCut) {
		int[] dp = new int[n + 1];
		
		dp[0] = 0; // base case
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				if(max < price[j] + dp[i - j]) {
					max = price[j] + dp[i - j];
					firstCut[i] = j;
				}				
			}
			dp[i] = max;
		}

		return dp[n];
	}
	
	public void printSolution(int n, int[] firstCut) {
		while(n > 0) {
			System.out.print(firstCut[n] + " ");
			n-=firstCut[n];
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] p = new int[] { 0, 1, 2, 3, 4, 13, 11, 13 };
		RodCutting rc = new RodCutting(p);
		int[] dp = new int[p.length+1];
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
		int[] firstCut = new int[p.length+1];
		System.out.println(rc.rodCuttingBottomUp(1,firstCut));
		rc.printSolution(1,firstCut);
		System.out.println(rc.rodCuttingBottomUp(2,firstCut));
		rc.printSolution(2,firstCut);
		System.out.println(rc.rodCuttingBottomUp(3,firstCut));
		rc.printSolution(3,firstCut);
		System.out.println(rc.rodCuttingBottomUp(4,firstCut));
		rc.printSolution(4,firstCut);
		System.out.println(rc.rodCuttingBottomUp(5,firstCut));
		rc.printSolution(5,firstCut);
		System.out.println(rc.rodCuttingBottomUp(6,firstCut));
		rc.printSolution(6,firstCut);
		System.out.println(rc.rodCuttingBottomUp(7,firstCut));
		rc.printSolution(7,firstCut);
	}

}
