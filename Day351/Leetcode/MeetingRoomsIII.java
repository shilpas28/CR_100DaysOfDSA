//Leetcode
//2402. Meeting Rooms III
//Time complexity: O(mlogm+mlogn)
//Space complexity: O(m+n)

package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

public class MeetingRoomsIII {

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 4 } };
        System.out.println(mostBooked(n, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {
        Queue<Pair<Integer, Long>> timePq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() > b.getValue()) {
                return 1;
            } else if (a.getValue() < b.getValue()) {
                return -1;
            }
            return a.getKey() - b.getKey();
        });
        Queue<Integer> poolPq = new PriorityQueue<>((a, b) -> a - b);
        Queue<int[]> meetPq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            poolPq.add(i);
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] res = new int[100];
        int p = 0;
        long t = 0;
        int m = meetings.length;
        while (p < m || !meetPq.isEmpty()) {
            // Extract a meetings ready to start for the moment t - push to the meetings
            // pool
            while (p < m && meetings[p][0] <= t) {
                meetPq.add(new int[] { meetings[p][0], meetings[p][1] - meetings[p++][0] });
            }
            // Extract the rooms ready for the moment t - i.e. where meeting is finished
            // already
            while (!timePq.isEmpty() && timePq.peek().getValue() <= t) {
                poolPq.add(timePq.poll().getKey());
            }
            // While we have meetings to assign and rooms for them - assign them
            while (!meetPq.isEmpty() && !poolPq.isEmpty()) {
                int room = poolPq.poll();
                res[room]++;
                int[] meet = meetPq.poll();
                timePq.add(new Pair<>(room, (long) t + (long) meet[1]));
            }
            long nextMeet = p < m ? (long) meetings[p][0] : Long.MAX_VALUE;
            long nextRoom = timePq.size() == n ? timePq.peek().getValue() : Long.MAX_VALUE;
            t = Math.min(nextMeet, nextRoom);
        }
        int maxCount = 0;
        int maxInd = -1;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > maxCount) {
                maxCount = res[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
}
