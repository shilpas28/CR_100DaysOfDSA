//GFG
//Pythagorean Triplet - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class PythagoreanTriplet_3 {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 6, 5 };
        System.out.println(pythagoreanTriplet(arr));
    }

    static boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];
        Arrays.sort(arr);
        for (int c = n - 1; c > 1; c--) {
            int a = 0, b = c - 1;
            while (a < b) {
                if (arr[a] + arr[b] == arr[c])
                    return true;

                else if (arr[a] + arr[b] < arr[c])
                    a++;
                else
                    b--;
            }
        }
        return false;
    }
}
