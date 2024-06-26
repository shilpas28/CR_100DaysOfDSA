//Leetcode
//165. Compare Version Numbers - Split Function
//Time complexity: O(Max(version1.length,version2.length)+n) --> O(n)
//Space complexity: O(n)

package Leetcode;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
