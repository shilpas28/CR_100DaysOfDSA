//Leetcode
//3373. Maximize the Number of Target Nodes After Connecting Trees II - DFS
//Time complexity: O(n+m)
//Space complexity: O(n+m)

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {

    public static void main(String[] args) {
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2)));
    }

    static Map<Integer, List<Integer>> tree1, tree2;
    static int[] color1, color2;
    static int[] nodeColor1, nodeColor2;

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        tree1 = new HashMap<>();
        tree2 = new HashMap<>();
        color1 = new int[2];
        color2 = new int[2];
        nodeColor1 = new int[n];
        nodeColor2 = new int[m];
        // build the trees
        build(edges1, tree1);
        build(edges2, tree2);
        // use bfs to color trees.
        bfs(tree1, color1, nodeColor1);
        bfs(tree2, color2, nodeColor2);
        int[] arr = new int[n];
        int max = Math.max(color2[0], color2[1]);
        for (int i = 0; i < n; i++) {
            arr[i] = color1[nodeColor1[i]] + max;
        }
        return arr;
    }

    static void build(int[][] edges, Map<Integer, List<Integer>> map) {
        int n = edges.length + 1;
        for (int i = 0; i < n; i++)
            map.put(i, new LinkedList<>());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
    }

    static void bfs(Map<Integer, List<Integer>> map, int[] color, int[] col) {
        int n = map.size();
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] top = q.poll();
            vis[top[0]] = true;
            col[top[0]] = top[1];
            color[top[1]]++;
            for (int adj : map.get(top[0]))
                if (!vis[adj]) {
                    // (top[1] + 1) % 2 to ensure [0, 1] coloring.
                    q.add(new int[] { adj, (top[1] + 1) % 2 });
                }
        }
    }
}
