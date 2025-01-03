//Leetcode
//1829. Maximum XOR for Each Query
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class MaximumXORForEachQuery_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 3 };
        int maximumBit = 2;
        System.out.println(Arrays.toString(getMaximumXor(nums, maximumBit)));
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int mask = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] res = new int[n];
        int curr = 0;
        
        for(int i = 0; i < n; i++) {
            curr ^= nums[i];
            res[n-i-1] = ~curr & mask;
        }
        
        return res;
    }
}
