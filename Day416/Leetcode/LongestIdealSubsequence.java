//Leetcode
//2370. Longest Ideal Subsequence
//Time complexity: O(N)
//Space complexity: O(150)

package Leetcode;

import java.util.Arrays;

public class LongestIdealSubsequence {

    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {

        int n = s.length();
        int dp[][] = new int[n + 1][150];
        for (int sub_array[] : dp)
            Arrays.fill(sub_array, -1);
        return helper_function(s, k, 0, '#', dp); // taken # as dummy char becuase in ascii table # is adjcent of z , so
                                                  // it will automatically cover by 150 dimension of dp
    }

    static int helper_function(String s, int k, int idx, char ch, int dp[][]) {

        if (idx == s.length())
            return 0;
        if (dp[idx][ch] != -1)
            return dp[idx][ch];
        int pick = 0;
        if (Math.abs(ch - s.charAt(idx)) <= k || ch == '#')
            pick = 1 + helper_function(s, k, idx + 1, s.charAt(idx), dp);
        int notpick = helper_function(s, k, idx + 1, ch, dp);
        return dp[idx][ch] = Math.max(pick, notpick);
    }
}
