//GFG
//Is it a tree ?
//Time complexity: O(N+M)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsItATree {

    public static void main(String[] args) {
        int N = 4, M = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(isTree(N, M, edges));
    }

    // @SuppressWarnings("all")
    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (ArrayList<Integer> x : edges) {
            adj.get(x.get(0)).add(x.get(1));
            adj.get(x.get(1)).add(x.get(0));
        }
        int vis[] = new int[n];
        Arrays.fill(vis, 0);
        Queue<int[]> q = new LinkedList<>();
        int arr[] = new int[2];
        arr[0] = 0;
        arr[1] = -1;
        q.add(arr);
        vis[0] = 1;
        while (!q.isEmpty()) {
            int temp[] = q.poll();
            for (int it : adj.get(temp[0])) {
                if (vis[it] == 0) {
                    vis[it] = 1;
                    int arr2[] = new int[2];
                    arr2[0] = it;
                    arr2[1] = temp[0];
                    q.add(arr2);
                } else {
                    if (it != temp[1])
                        return false;
                }
            }
        }
        for (int i = 0; i < n; i++)
            if (vis[i] == 0)
                return false;
        return true;
    }
}
