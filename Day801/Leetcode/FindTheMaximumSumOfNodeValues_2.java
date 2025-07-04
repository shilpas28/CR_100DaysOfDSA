//Leetcode
//3068. Find the Maximum Sum of Node Values - Recursion with memoization
//Time complexity: O(n), there can be at most 2 * n subproblems (check the size for temp array)
//Space complexity: O(n) we use O(n) for recursion stack and O(2 * n) for memoization so O(3n) in total or just O(n)

public class FindTheMaximumSumOfNodeValues_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 3;
        int[][] edges = { { 0, 1 }, { 0, 2 } };
        System.out.println(maximumValueSum(nums, k, edges));
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {

        int n = nums.length;
        long[][] temp = new long[n][2]; // temp[current_index(node)][is_even]
        for (int i = 0; i < n; i++) {
            temp[i][0] = -1;
            temp[i][1] = -1;
        }
        return calculateMax(nums, n, k, 0, 1, temp); // is_even == 1 because we have XORed 0 nodes which is even
    }

    // calculate_max -> cur_ind -> cur_index of the tree and is_even represents
    // whether we have already changed (XOR) even or odd number of nodes
    static long calculateMax(int[] nums, int n, int k, int curInd, int isEven, long[][] temp) {

        if (curInd == n) { // if we go to node which doesn't exist
            return isEven == 1 ? 0 : Long.MIN_VALUE;
        }
        if (temp[curInd][isEven] != -1) { // if we've already encountered this state
            return temp[curInd][isEven];
        }
        // checking all possible variants (no XOR or XOR)
        long noXor = nums[curInd] + calculateMax(nums, n, k, curInd + 1, isEven, temp); // we don't change the number of
                                                                                        // XOR nodes
        long withXor = (nums[curInd] ^ k) + calculateMax(nums, n, k, curInd + 1, 1 - isEven, temp); // we added 1 XORed
                                                                                                    // node

        long mxPossible = Math.max(noXor, withXor);
        temp[curInd][isEven] = mxPossible;
        return mxPossible;
    }
}
