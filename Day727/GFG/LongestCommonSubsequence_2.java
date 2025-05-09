//GFG
//Longest Common Subsequence
//Time complexity: O(N*M)
//Space complexity: O(N*M)

import java.util.Arrays;

public class LongestCommonSubsequence_2 {

    public static void main(String[] args) {
        String s1 = "ABCDGH", s2 = "AEDFHR";
        System.out.println(lcs(s1, s2));
    }

    static int lcs(String s1, String s2) {
        // code here
        int x = s1.length();
        int y = s2.length();
        int n = x;
        int m = y;
        int dp[][] = new int[n + 1][m + 1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        return dp[n][m];
    }
}
