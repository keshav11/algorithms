package DynamicProgramming;


public class CoinChangeWays {

    int numWays(int[] coins, int total) {
        int[][] dp = new int[total+1][coins.length];
        for (int i = 0; i <= total; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                else if(i >= coins[j]) {

                    dp[i][j] = dp[i-coins[j]][j] + dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[total][coins.length-1];

    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeWays().numWays(new int[] {2, 3, 7}, 23 ));
    }
}
