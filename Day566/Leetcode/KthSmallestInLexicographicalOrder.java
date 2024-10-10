//Leetcode
//440. K-th Smallest in Lexicographical Order
//Time complexity: O(log n) since, in each iteration, we're moving either down or sideways in the lexicographical tree. The 
//number of levels is proportional to the logarithm of n.
//Space complexity: O(1) because we use a few variables to track the current number, and no additional data structures are used 
//apart from integer variables.

public class KthSmallestInLexicographicalOrder {

    public static void main(String[] args) {
        int n = 13, k = 2;
        System.out.println(findKthNumber(n, k));
    }

    public static int findKthNumber(int n, int k) {
        long num = 1;
        for (int i = 1; i < k;) {
            int req = getReqNum(num, num + 1, n);
            if (i + req <= k) {
                i += req;
                num++;
            } else {
                i++;
                num *= 10;
            }
        }
        return (int) num;
    }

    static int getReqNum(long a, long b, long n) {
        int gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}