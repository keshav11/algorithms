package DynamicProgramming;

public class SubsetSum {

    public static boolean isSubsetSum(int[] set, int num) {
        boolean[] dp = new boolean[num+1];
        dp[0] = true; // 0 sum is always possible
        for(int j = 0; j < set.length; j++) {
            for(int i = num; i >= set[j]; i--) {
                if(i >= set[j])
                    dp[i] = dp[i] || dp[i-set[j]];
            }
        }
        return dp[num];
    }
    
    public static void main(String[] args){
        for (int i = 1; i <= 10; i++) {
            System.out.println(isSubsetSum(new int[] {1, 2}, i));
        }
    }

}
