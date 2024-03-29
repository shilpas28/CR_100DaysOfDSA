//GFG
//String's Count
//Time complexity: O(1)
//Space complexity: O(1)

public class StringsCount {

    public static void main(String[] args) {
        long n = 1;
        System.out.println(countStr(n));
    }

    static long countStr(long n) {
        // code here
        // all a --> 1
        // 1b and a --> n
        // 1c and a --> n
        // 2c and a --> n*(n-1)/2
        // 1b,1c and a --> n*(n-1)
        // 1b,2c and a --> n(n-1)(n-2)/2

        return 1 + 2 * n + n * (n - 1) / 2 + n * (n - 1) + n * (n - 1) * (n - 2) / 2;
    }
}
