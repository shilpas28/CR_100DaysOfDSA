//Leetcode
//1550. Three Consecutive Odds
//Time complexity: O(N)
//Space complexity: O(N)

public class ThreeConsecutiveOdds {

    public static void main(String[] args) {
        int arr[] = { 2, 6, 4, 1 };
        System.out.println(threeConsecutiveOdds(arr));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {

        StringBuilder binaryString = new StringBuilder();
        for (int num : arr) {
            binaryString.append(num % 2);
        }
        return binaryString.toString().contains("111");
    }
}
