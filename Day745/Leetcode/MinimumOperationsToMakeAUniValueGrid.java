//Leetcode
//2033. Minimum Operations to Make a Uni-Value Grid -  Sorting and Median
//Time complexity: O(mn×logmn)
//Space complexity: O(mn)

import java.util.ArrayList;
import java.util.Collections;

public class MinimumOperationsToMakeAUniValueGrid {

    public static void main(String[] args) {
        int[][] grid = { { 2, 4 }, { 6, 8 } };
        int x = 2;
        System.out.println(minOperations(grid, x));
    }

    public static int minOperations(int[][] grid, int x) {
        // Create a list to store all the numbers from the grid
        ArrayList<Integer> numsArray = new ArrayList<>();
        int result = 0;
        // Flatten the grid into numsArray
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                numsArray.add(grid[row][col]);
            }
        }
        // Sort numsArray in non-decreasing order to easily find the median
        Collections.sort(numsArray);
        int length = numsArray.size();
        // Store the median element as the final common value
        int finalCommonNumber = numsArray.get(length / 2);
        // Iterate through each number in numsArray
        for (int number : numsArray) {
            // If the remainder when divided by x is different, return -1
            if (number % x != finalCommonNumber % x) {
                return -1;
            }
            // Add the number of operations required to make the current number equal to
            // finalCommonNumber
            result += Math.abs(finalCommonNumber - number) / x;
        }
        return result;
    }
}
