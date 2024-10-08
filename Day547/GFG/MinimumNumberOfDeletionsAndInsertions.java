//GFG
//Minimum number of deletions and insertions
//Time complexity: O(|str1|*|str2|)
//Space complexity: O(|str1|*|str2|)

public class MinimumNumberOfDeletionsAndInsertions {

    public static void main(String[] args) {
        String str1 = "heap", str2 = "pea";
        System.out.println(minOperations(str1, str2));
    }

    public static int minOperations(String str1, String str2) {
        // Your code goes here
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? 1 + dp[i - 1][j - 1]
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return n + m - 2 * dp[n][m];
    }
}
