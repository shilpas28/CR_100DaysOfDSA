//Leetcode
//1406. Stone Game III
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class StoneGameIII {

    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 7 };
        System.out.println(stoneGameIII(values));
    }

    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[3];
        for (int i = n - 1; i >= 0; i--) {
            int takeOne = stoneValue[i] - dp[(i + 1) % 3];
            int takeTwo = Integer.MIN_VALUE;
            if (i + 1 < n)
                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 3];
            int takeThree = Integer.MIN_VALUE;
            if (i + 2 < n)
                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 3];
            dp[i % 3] = Math.max(Math.max(takeOne, takeTwo), takeThree);
        }
        int value = dp[0];
        if (value > 0)
            return "Alice";
        else if (value < 0)
            return "Bob";
        else
            return "Tie";
    }
}
