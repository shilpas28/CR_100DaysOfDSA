//GFG
//Maximum Index
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class MaximumIndex_2 {

    public static void main(String[] args) {
        int n = 9;
        int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        System.out.println(maxIndexDiff(a, n));
    }

    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) {

        // Your code here
        int right[] = new int[n];
        right[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(a[i], right[i + 1]);
        int i = 0, j = 0, ans = Integer.MIN_VALUE;
        while (i < n && j < n) {
            if (a[i] <= right[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else
                i++;
        }
        return ans;
    }
}
