//GFG
//Longest repeating and non-overlapping substring
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package GFG;

public class LongestRepeatingAndNonOverlappingSubstring_2 {

    public static void main(String[] args) {
        int n = 7;
        String s = "heheheh";
        System.out.println(longestSubstring(s, n));
    }

    static String longestSubstring(String s, int n) {
        // code here
        int[][] LCS = new int[n + 1][n + 1];
        int res_length = 0;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) &&
                        LCS[i - 1][j - 1] + 1 <= (j - i)) { // no overlapping
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;

                    if (LCS[i][j] > res_length) { // do not update for equal, need 1st occurence
                        res_length = LCS[i][j];
                        idx = i - 1;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder(); // To store result
        if (res_length > 0) {
            for (int i = idx - res_length + 1; i <= idx; i++) {
                res.append(s.charAt(i));
            }
        } else
            res.append("-1");
        return res.toString();
    }
}
