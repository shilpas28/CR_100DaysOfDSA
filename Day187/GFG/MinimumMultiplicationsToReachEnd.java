//GFG
//Minimum Multiplications to reach End
//Time complexity: O(10^5)
//Space complexity: O(10^5)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {

    public static void main(String[] args) {
        int arr[] = { 2, 5, 7 };
        int start = 3, end = 30;
        System.out.println(minimumMultiplications(arr, start, end));
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    static int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if (start == end)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        int vis[] = new int[100000];
        q.add(new Pair(0, start));

        while (q.size() > 0) {
            Pair p = q.remove();
            int steps = p.a;
            int num = p.b;

            for (int i = 0; i < arr.length; i++) {
                long temp = arr[i] * num % 100000;
                int ns = (int) temp;
                if (ns == end)
                    return steps + 1;
                if (vis[ns] == 0) {
                    q.add(new Pair(steps + 1, ns));
                    vis[ns] = 1;
                }
            }
        }
        return -1;
    }
}
