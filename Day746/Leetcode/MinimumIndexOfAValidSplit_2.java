//Leetcode
//Minimum Platforms - Boyer-Moore Majority Voting Algorithm
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MinimumIndexOfAValidSplit_2 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(1);
        nums.add(3);
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(7);
        nums.add(1);
        nums.add(2);
        nums.add(1);
        System.out.println(minimumIndex(nums));
    }

    public static int minimumIndex(List<Integer> nums) {
        // Find the majority element
        int x = nums.get(0), count = 0, xCount = 0, n = nums.size();

        for (int num : nums) {
            if (num == x) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                x = num;
                count = 1;
            }
        }
        // Count frequency of majority element
        for (int num : nums) {
            if (num == x) {
                xCount++;
            }
        }
        // Check if valid split is possible
        count = 0;
        for (int index = 0; index < n; index++) {
            if (nums.get(index) == x) {
                count++;
            }
            int remainingCount = xCount - count;
            // Check if both left and right partitions satisfy the condition
            if (count * 2 > index + 1 && remainingCount * 2 > n - index - 1) {
                return index;
            }
        }
        return -1;
    }
}
