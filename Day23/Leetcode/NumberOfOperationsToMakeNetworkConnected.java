//Leetcode - using Disjoint Set Union/Union-Find 
//1319. Number of Operations to Make Network Connected
/*Time complexity: O(E*4α)+O(N*4α) where E = no. of edges and N = no. of nodes. The first term is to calculate the number of 
extra edges and the second term is to count the number of components. 4α is for the disjoint set operation we have used and 
this term is so small that it can be considered constant. */
//Space complexity: O(2N) where N = no. of nodes. 2N for the two arrays(parent and size) of size N we have used inside the disjoint set.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {

    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(makeConnected(n, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = connections.length;
        for (int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i)
                cntC++;
        }
        int ans = cntC - 1;
        if (cntExtras >= ans)
            return ans;
        return -1;
    }

}
