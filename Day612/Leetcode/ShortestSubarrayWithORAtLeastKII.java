//Leetcode
//3097. Shortest Subarray With OR at Least K II - Binary Search on Subarray Length
//Time complexity: O(nlogn)
//Space complexity: O(32)≈O(1)

public class ShortestSubarrayWithORAtLeastKII {

    public static void main(String[] args) {
        int nums[] = { 2, 1, 8 };
        int k = 10;
        System.out.println(minimumSubarrayLength(nums, k));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, start = 1, end = n + 1, mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (!isSpecial(nums, k, mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start != n + 1 ? start : -1;
    }

    static boolean isSpecial(int[] nums, int k, int len) {
        // checks if special subarray exists for length len, time: O(n)
        int n = nums.length;
        int[] bits = new int[32];
        for (int i = 0; i < n; i++) {
            update(bits, nums[i], 1); // insert nums[i] into window
            if (i >= len) {
                update(bits, nums[i - len], -1); // remove nums[i - len] from window
            }
            if (i >= len - 1 && bitsToNum(bits) >= k) {
                // special subarray found
                return true;
            }
        }
        return false;
    }

    static void update(int[] bits, int x, int change) {
        // insert or remove element from window, time: O(32)
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != 0) {
                bits[i] += change;
            }
        }
    }

    static int bitsToNum(int[] bits) {
        // convert 32-size bits array to integer, time: O(32)
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }
}