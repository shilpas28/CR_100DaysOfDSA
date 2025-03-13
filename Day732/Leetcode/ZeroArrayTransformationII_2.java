//Leetcode
//3356. Zero Array Transformation II - Line Sweep
//Time complexity: O(N+M)
//Space complexity: O(N)

public class ZeroArrayTransformationII_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2 };
        int[][] queries = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        System.out.println(minZeroArray(nums, queries));
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] differenceArray = new int[n + 1];
        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (sum + differenceArray[index] < nums[index]) {
                k++;
                // Zero array isn't formed after all queries are processed
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0], right = queries[k - 1][1], val = queries[k - 1][2];
                // Process start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            // Update prefix sum at current index
            sum += differenceArray[index];
        }
        return k;
    }
}
