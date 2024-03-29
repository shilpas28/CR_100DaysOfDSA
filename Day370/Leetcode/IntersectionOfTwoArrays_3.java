//Leetcode
//349. Intersection of Two Arrays - Using 1 hashset 
//Time complexity: O(m+n)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays_3 {

    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        // Add all elements to set from array 1
        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        for (int j = 0; j < nums2.length; j++) {
            // If present in array 2 then add to res and remove from set
            if (set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            arr[i] = res.get(i);
        return arr;
    }
}
