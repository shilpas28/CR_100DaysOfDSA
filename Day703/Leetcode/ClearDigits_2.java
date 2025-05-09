//Leetcode
//3174. Clear Digits - Stack-Like
//Time complexity: O(N)
//Space complexity: O(N)

public class ClearDigits_2 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(clearDigits(s));
    }

    public static String clearDigits(String s) {
        StringBuilder answer = new StringBuilder();
        // Iterate over each character in the input string
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            // If the current character is a digit
            if (Character.isDigit(s.charAt(charIndex)) && answer.length() != 0) {
                // If the answer string is not empty, remove the last character
                answer.setLength(answer.length() - 1);
            } else {
                // If the character is not a digit, add it to the answer
                answer.append(s.charAt(charIndex));
            }
        }
        return answer.toString();
    }
}
