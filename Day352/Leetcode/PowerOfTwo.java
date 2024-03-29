//Leetcode
//231. Power of Two
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 16;
        int y = 3;
        System.out.println(isPowerOfTwo(n));
        System.out.println(isPowerOfTwo(y));
    }

    public static boolean isPowerOfTwo(int n) {
        long i = 1;
        while (i < n) {
            i *= 2;
        }
        return i == n;
    }
}
