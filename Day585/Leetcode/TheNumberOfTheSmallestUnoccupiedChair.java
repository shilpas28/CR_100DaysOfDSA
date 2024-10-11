//Leetcode
//1942. The Number of the Smallest Unoccupied Chair - USing 2 min heaps
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {

    public static void main(String[] args) {
        int[][] times = { { 1, 4 }, { 2, 3 }, { 4, 6 } };
        int targetFriend = 1;
        System.out.println(smallestChair(times, targetFriend));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < times.length; ++i)
            available.offer(i);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; ++i) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0])
                available.offer(pq.poll()[1]);

            if (times[i][0] == targetStart)
                break;
            pq.offer(new int[] { times[i][1], available.poll() });
        }
        return available.peek();
    }
}
