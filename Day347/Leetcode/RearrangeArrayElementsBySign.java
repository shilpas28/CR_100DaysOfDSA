//Leetcode
//2149. Rearrange Array Elements by Sign - Brute Force
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                v1.add(num);
            } else {
                v2.add(num);
            }
        }

        int ind1 = 0, ind2 = 0;

        while (ind2 < nums.length / 2) {
            ans.add(v1.get(ind1));
            ind1++;
            ans.add(v2.get(ind2));
            ind2++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
