package dp;

public class LongestCommonSubsequence {

    int lcs(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }


    int longestRepeatedSubsequence(String str) {
        int[][] dp = new int[str.length()+1][str.length()+1];
        for(int i = 0; i <= str.length(); i++) {
            for (int j = 0; j <= str.length(); j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str.charAt(i-1) == str.charAt(j-1) && i != j) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[str.length()][str.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().lcs("hello", "helpao"));
        System.out.println(new LongestCommonSubsequence().longestRepeatedSubsequence("helloo"));
        System.out.println(new LongestCommonSubsequence().longestRepeatedSubsequence("abbbcdabcdaa"));
    }
}
