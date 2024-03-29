//GFG
//Power of 2
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class PowerOf2 {

    public static void main(String[] args) {
        long N = 8;
        System.out.println(isPowerofTwo(N));
    }

    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n) {

        // Your code here
        while (n > 1 && n % 2 == 0) {
            n = n / 2;
        }
        return n == 1 ? true : false;
    }
}
