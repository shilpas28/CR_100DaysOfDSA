//Leetcode
//1624. Largest Substring Between Two Equal Characters - Using Array
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters_3 {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] v1 = new int[26];
        int[] v2 = new int[26];
        Arrays.fill(v1, -1);
        Arrays.fill(v2, -1);
        int ans = -1;

        for (int i = 0; i < s.length(); ++i) {
            int temp = s.charAt(i) - 'a';

            if (v1[temp] == -1) {
                v1[temp] = i;
            } else {
                v2[temp] = i;
                ans = Math.max(ans, v2[temp] - v1[temp] - 1);
            }
        }
        return ans;
    }
}
