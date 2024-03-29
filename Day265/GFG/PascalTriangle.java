//GFG
//Pascal Triangle
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(nthRowOfPascalTriangle(N));
    }

    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        long mod = 1000000007;
        ArrayList<Long> al = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            al.add(0L); // Initialize each element to 0L
        }
        al.set(0, 1L);
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j >= 1; j--) {
                al.set(j, (al.get(j) % mod + al.get(j - 1) % mod) % mod);
            }
        }
        return al;
    }
}
