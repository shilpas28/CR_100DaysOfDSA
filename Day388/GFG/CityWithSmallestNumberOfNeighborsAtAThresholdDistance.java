//GFG
//City With the Smallest Number of Neighbors at a Threshold Distance
//Time complexity: O(V^3), as we have three nested loops each running for V times, where V = no. of vertices
//Space complexity: O(V^2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph

package GFG;

public class CityWithSmallestNumberOfNeighborsAtAThresholdDistance {

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] edges = { { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 } };
        int distanceThreshold = 4;
        System.out.println(findCity(n, m, edges, distanceThreshold));
    }

    static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE ||
                            dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
