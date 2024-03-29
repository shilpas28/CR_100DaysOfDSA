//GFG
//Minimize the Heights II
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class MinimizeTheHeightsII {

    public static void main(String[] args) {
        int K = 2, N = 4;
        int Arr[] = { 1, 5, 8, 10 };
        System.out.println(getMinDiff(Arr, N, K));
    }

    static int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int minimum = arr[0] + k;
        int maximum = arr[n - 1] - k;
        int curr_max, curr_min;
        for (int i = 0; i < n - 1; i++) {
            curr_min = Math.min(arr[i + 1] - k, minimum);
            curr_max = Math.max(arr[i] + k, maximum);
            if (curr_min >= 0) {
                ans = Math.min(ans, curr_max - curr_min);
            }
        }
        return ans;
    }
}
