//Leetcode
//1155. Number of Dice Rolls With Target Sum - Bottom Up/Tabulation
//Time complexity: O(n * target)
//Space complexity: O(n * target)

package Leetcode;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum_3 {

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(numRollsToTarget(n, k, target));
    }

    static int mod = (int) Math.pow(10, 9) + 7;

    public static int numRollsToTarget(int n, int k, int target) {
        int[][] mem = new int[n + 1][target + 1];
        for (int[] a : mem)
            Arrays.fill(a, -1);
        return numRollsToTarget(n, k, target, mem);
    }

    static int numRollsToTarget(int n, int k, int target, int[][] mem) {
        if (target == 0 && n == 0)
            return 1;
        if (target < 0 || n == 0)
            return 0;
        if (mem[n][target] != -1)
            return mem[n][target];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            target -= i;
            count = (count + numRollsToTarget(n - 1, k, target, mem) % mod) % mod;
            target += i; // backtracking
        }
        return mem[n][target] = count;
    }
}
