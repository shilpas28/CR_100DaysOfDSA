//Leetcode
//2044. Count Number of Maximum Bitwise-OR Subsets
//Time complexity: O(2^N)
//Space complexity: O(N)

public class CountNumberOfMaximumBitwiseORSubsets {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        System.out.println(countMaxOrSubsets(nums));
    }

    public static int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        // Step 1: Compute the maximum OR
        for (int num : nums)
            maxOR |= num;

        int[] count = new int[1];
        // Step 2: Backtrack to count the subsets
        backtrack(nums, 0, 0, maxOR, count);
        return count[0];
    }

    static void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count) {
        if (currentOR == maxOR)
            count[0]++;

        for (int i = index; i < nums.length; i++)
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
    }
}
