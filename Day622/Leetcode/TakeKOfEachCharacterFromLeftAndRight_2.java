//Leetcode
//2516. Take K of Each Character From Left and Right - Sliding Window
//Time complexity: O(N)
//Space complexity: O(1)

public class TakeKOfEachCharacterFromLeftAndRight_2 {

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(s, k));
    }

    public static int takeCharacters(String s, int k) {
        int[] charCount = new int[3];
        char[] chars = s.toCharArray();
        int length = chars.length;

        int left;
        for (left = 0; left < length; left++) {
            charCount[chars[left] - 'a']++;
            if (isValidCount(charCount, k)) {
                break;
            }
        }

        if (left == length)
            return -1;

        int currentCount = left + 1;
        int minCount = currentCount;
        int right = length - 1;

        while (left >= 0) {
            int currentChar = chars[left] - 'a';

            if (charCount[currentChar] == k) {
                while (chars[left] != chars[right]) {
                    charCount[chars[right] - 'a']++;
                    right--;
                    currentCount++;
                }
                right--;
            } else {
                charCount[currentChar]--;
                currentCount--;
                minCount = Math.min(currentCount, minCount);
            }
            left--;
        }
        return minCount;
    }

    static boolean isValidCount(int[] count, int k) {
        return count[0] >= k && count[1] >= k && count[2] >= k;
    }
}