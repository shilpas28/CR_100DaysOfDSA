//GFG
//Yet Another Query Problem
//Time complexity:
//Space complexity:

package Day11.GFG;

import java.util.ArrayList;

public class YetAnotherQueryProblem {

    public static void main(String[] args) {
        int N = 5, num = 3;
        int A[] = { 1, 1, 3, 4, 3 };
        int Q[][] = { { 0, 2, 2 }, { 0, 2, 1 }, { 0, 4, 2 } };
        System.out.println(solveQueries(N, num, A, Q));
    }

    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int frequency[][] = new int[N][N + 1];

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = i; j < N; j++) {
                if (A[i] == A[j]) {
                    cnt++;
                }
            }
            frequency[i][cnt]++;
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j < N; j++) {
                frequency[j][i] += frequency[j - 1][i];
            }
        }

        for (int i = 0; i < num; i++) {
            int L = Q[i][0];
            int R = Q[i][1];
            int K = Q[i][2];
            ans.add((L == 0 ? frequency[R][K] : frequency[R][K] - frequency[L - 1][K]));
        }

        return ans;
    }
}
