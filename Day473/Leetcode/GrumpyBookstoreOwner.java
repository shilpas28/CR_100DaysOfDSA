//Leetcode
//1052. Grumpy Bookstore Owner
//Time complexity: O(N)
//Space complexity: O(1)

public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 }, grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        for (int j = 0; j < n; j++) {
            curWin += customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if (j >= minutes - 1) {
                curWin -= customers[i] * grumpy[i++];
            }
        }
        int res = maxWin;
        for (i = 0; i < grumpy.length; i++) {
            res += customers[i] * (1 - grumpy[i]);
        }
        return res;
    }
}
