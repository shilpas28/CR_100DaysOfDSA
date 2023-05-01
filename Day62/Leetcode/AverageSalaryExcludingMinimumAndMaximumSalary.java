//Leetcode
//1491. Average Salary Excluding the Minimum and Maximum Salary
//Time complexity: O(NlogN)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class AverageSalaryExcludingMinimumAndMaximumSalary {

    public static void main(String[] args) {
        int[] salary = { 4000, 3000, 1000, 2000 };
        System.out.println(average(salary));
    }

    public static double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0.0;
        int count = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
            count++;
        }
        return sum / count;
    }
}
