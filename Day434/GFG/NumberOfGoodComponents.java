//GFG
//Number of Good Components
//Time complexity: O(v+e)
//Space complexity: O(depth of the graph)

package GFG;

import java.util.ArrayList;

public class NumberOfGoodComponents {

    public static void main(String[] args) {
        int e = 5, v = 7;
        int[][] edges = { { 1, 2 }, { 7, 2 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
        System.out.println(findNumberOfGoodComponent(e, v, edges));
    }

    static int v_count;
    static int e_count;
    static boolean vis[];

    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // if the graph is undirected
        }
        vis = new boolean[v + 1];
        // dfs for all vertices
        int ans = 0;
        for (int i = 1; i <= v; i++) {
            if (!vis[i]) {
                v_count = e_count = 0;
                dfs(adj, i);
                if (e_count == (v_count * (v_count - 1)))
                    ans++;
            }
        }
        return ans;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int st) {
        vis[st] = true;
        v_count++;
        e_count += adj.get(st).size();
        // itr for nei
        for (int nei : adj.get(st)) {
            if (!vis[nei])
                dfs(adj, nei);
        }
    }
}
