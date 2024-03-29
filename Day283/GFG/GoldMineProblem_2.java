//GFG
//Gold Mine Problem
//Time complexity: O(n*m)
//Space complexity: O(n*m)

package GFG;

public class GoldMineProblem_2 {

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] M = { { 1, 3, 3 },
                { 2, 1, 4 },
                { 0, 6, 4 } };
        System.out.println(maxGold(n, m, M));
    }

    static int maxGold(int n, int m, int M[][]) {
        // code here
        int arr[][] = new int[n][m];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1)
                    arr[i][j] = M[i][j];
                else {
                    int ud = (i - 1) >= 0 ? arr[i - 1][j + 1] : 0;
                    int r = Math.max(ud, arr[i][j + 1]);
                    int ld = (i + 1) < n ? arr[i + 1][j + 1] : 0;
                    int max = Math.max(r, ld);

                    arr[i][j] = max + M[i][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, arr[i][0]);

        return res;
    }
}
