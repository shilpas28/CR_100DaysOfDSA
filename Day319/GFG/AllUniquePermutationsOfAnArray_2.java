//GFG
//All Unique Permutations of an array
//Time complexity: O(n*n!)
//Space complexity: O(n*n!)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutationsOfAnArray_2 {

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        System.out.println(uniquePerms(arr, n));
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        Set<ArrayList<Integer>> hst = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Collections.sort(arr);
        check(arr, visit, hst, res, curr);
        return res;
    }

    static void check(ArrayList<Integer> arr, boolean[] visit, Set<ArrayList<Integer>> hst,
            ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr) {
        if (curr.size() == arr.size()) {
            if (!hst.contains(curr)) {
                hst.add(new ArrayList<>(curr));
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (visit[i] == true)
                continue;
            visit[i] = true;
            curr.add(arr.get(i));
            check(arr, visit, hst, res, curr);
            visit[i] = false;
            curr.remove(curr.size() - 1);
        }
    }

}
