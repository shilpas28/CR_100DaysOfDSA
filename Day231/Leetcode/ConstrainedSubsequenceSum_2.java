//Leetcode 
//1425. Constrained Subsequence Sum - DP + Decreasing Monotonic Queue
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ConstrainedSubsequenceSum_2 {

    public static void main(String[] args) {
        int[] nums = { 10, 2, -10, 5, 20 };
        int k = 2;
        System.out.println(constrainedSubsetSum(nums, k));
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = Math.max(0, deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            dp[i] = nums[i] + max;
            ans = Math.max(ans, dp[i]);
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard
                                                                        // the tail since it's useless
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k
                deque.removeFirst();
            }
        }
        return ans;
    }
}
