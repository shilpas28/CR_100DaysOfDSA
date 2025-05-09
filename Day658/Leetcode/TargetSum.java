//Leetcode
//494. Target Sum - Memoization/Top down
//Time complexity: O(N*K) - There are N*K states therefore at max N*K new problems will be solved.
//Space complexity: O(N*K) + O(N) - We are using a recursion stack space(O(N)) and a 2D array (O(N*K)).

package Leetcode;

import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }
        // Checking for edge cases
        if (totSum - target < 0)
            return 0;
        if ((totSum - target) % 2 == 1)
            return 0;

        int s2 = (totSum - target) / 2;

        int dp[][] = new int[n][s2 + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return countPartitionsUtil(n - 1, s2, nums, dp);
    }

    static int countPartitionsUtil(int ind, int target, int[] arr, int[][] dp) {

        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = countPartitionsUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = countPartitionsUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = (notTaken + taken);
    }
}
