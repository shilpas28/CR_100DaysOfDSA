//Leetcode
//1368. Minimum Cost to Make at Least One Valid Path in a Grid - Dijkstra's Algorithm 
//Time complexity: O((n*m)*log(n*m))
//Space complexity: O(n*m)

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid_2 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        System.out.println(minCost(grid));
    }

    // Direction vectors: right, left, down, up (matching grid values 1,2,3,4)
    static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int minCost(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;
        // Min-heap ordered by cost. Each element is [cost, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, 0 });
        // Track minimum cost to reach each cell
        int[][] minCost = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], row = curr[1], col = curr[2];
            // Skip if we've found a better path to this cell
            if (minCost[row][col] != cost)
                continue;
            // Try all four directions
            for (int dir = 0; dir < 4; dir++) {
                int newRow = row + dirs[dir][0];
                int newCol = col + dirs[dir][1];
                // Check if new position is valid
                if (newRow >= 0 &&
                        newRow < numRows &&
                        newCol >= 0 &&
                        newCol < numCols) {
                    // Add cost=1 if we need to change direction
                    int newCost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);
                    // Update if we found a better path
                    if (minCost[newRow][newCol] > newCost) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[] { newCost, newRow, newCol });
                    }
                }
            }
        }
        return minCost[numRows - 1][numCols - 1];
    }
}
