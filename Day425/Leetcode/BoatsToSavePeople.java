//Leetcode
//881. Boats to Save People
//Time complexity: O(nlogn)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] people = { 3, 5, 3, 4 };
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            if ((people[l] + people[r]) <= limit) {

                l++;
                r--;
            } else {

                r--;
            }
            count++;
        }
        return count;
    }
}
