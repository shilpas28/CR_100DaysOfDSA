//Leetcode
//2466. Count Ways To Build Good Strings - Dynamic Programming (Recursive)
//Time complexity: O(high)
//Space complexity: O(high)

import java.util.Arrays;

public class CountWaysToBuildGoodStrings_2 {

    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStrings(low, high, zero, one));
    }

    static int[] dp;
    static int mod = 1_000_000_007;

    public static int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        // Add up the number of strings with each valid length [low ~ high].
        int answer = 0;
        for (int end = low; end <= high; ++end) {
            answer += dfs(end, zero, one);
            answer %= mod;
        }
        return answer;
    }

    // Find the number of good strings of length `end`.
    static int dfs(int end, int zero, int one) {
        if (dp[end] != -1)
            return dp[end];
        int count = 0;
        if (end >= one) {
            count += dfs(end - one, zero, one);
        }
        if (end >= zero) {
            count += dfs(end - zero, zero, one);
        }
        dp[end] = count % mod;
        return dp[end];
    }
}
