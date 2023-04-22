//GFG 
//Smaller Sum - using Binary Search (better method)
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class SmallerSum_1 {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = { 1, 2, 3 };
        System.out.println(Arrays.toString(smallerSum(n, arr)));
    }

    public static long[] smallerSum(int n, int arr[]) {
        long[] ans = new long[n];
        int in = 0;
        long[] prefixSum = new long[n];
        int[] arrcpy = new int[n];

        for (int i = 0; i < n; i++)
            arrcpy[i] = arr[i];

        Arrays.sort(arrcpy);
        prefixSum[0] = arrcpy[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + arrcpy[i];
        for (int val : arr) {
            int index = binarySearch(val, arrcpy);

            if (index != 0)
                ans[in++] = prefixSum[index - 1];
            else
                in++;
        }
        return ans;
    }

    public static int binarySearch(int val, int[] arr) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < val)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
