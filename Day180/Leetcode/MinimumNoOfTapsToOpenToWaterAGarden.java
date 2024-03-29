//Leetcode
//1326. Minimum Number of Taps to Open to Water a Garden
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class MinimumNoOfTapsToOpenToWaterAGarden {

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = { 3, 4, 1, 1, 0, 0 };
        System.out.println(minTaps(n, ranges));
    }

    public static int minTaps(int n, int[] ranges) {
        int len = ranges.length;
        int[] dp = new int[len];
        Arrays.fill(dp, len + 1);
        dp[0] = 0;

        for (int i = 0; i < len; i++) {
            int start = Math.max(i - ranges[i], 0);
            int end = Math.min(i + ranges[i], len - 1);
            for (int j = start; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }
        return dp[len - 1] == len + 1 ? -1 : dp[len - 1];
    }
}
