//Leetcode
//629. K Inverse Pairs Array
//Time complexity: O(N*K)
//Space complexity: O(N*K) 

package Leetcode;

public class KInversePairsArray_2 {

    public static void main(String[] args) {
        int n = 3, k = 1;
        System.out.println(kInversePairs(n, k));
    }

    public static int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val = (dp[i - 1][j] + MOD - (j - i >= 0 ? dp[i - 1][j - i] : 0)) % MOD;
                    dp[i][j] = (dp[i][j - 1] + val) % MOD;
                }
            }
        }
        return (dp[n][k] + MOD - (k > 0 ? dp[n][k - 1] : 0)) % MOD;
    }
}
