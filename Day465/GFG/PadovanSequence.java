//GFG
//Padovan Sequence
//Time complexity: O(N)
//Space complexity: O(1)

public class PadovanSequence {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(padovanSequence(n));
    }

    public static int padovanSequence(int n) {
        // code here.
        if (n <= 2)
            return 1;
        int a = 1, b = 1, c = 1, temp = 0, mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            temp = (a + b) % mod;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
