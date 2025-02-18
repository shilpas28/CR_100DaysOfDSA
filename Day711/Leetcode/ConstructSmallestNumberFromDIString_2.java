//Leetcode
//2375. Construct Smallest Number From DI String - Optimization with Bit Masking 
//Time complexity: O(9^n)
//Space complexity: O(n)

public class ConstructSmallestNumberFromDIString_2 {

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
    }

    public static String smallestNumber(String pattern) {
        return String.valueOf(findSmallestNumber(pattern, 0, 0, 0));
    }

    // Recursively find the smallest number that satisfies the pattern
    static int findSmallestNumber(
            String pattern,
            int currentPosition,
            int usedDigitsMask,
            int currentNum) {
        // Base case: return the current number when the whole pattern is processed
        if (currentPosition > pattern.length())
            return currentNum;

        int result = Integer.MAX_VALUE;
        int lastDigit = currentNum % 10;
        boolean shouldIncrement = currentPosition == 0 || pattern.charAt(currentPosition - 1) == 'I';
        // Try all possible digits (1 to 9) that are not yet used and follow the pattern
        for (int currentDigit = 1; currentDigit <= 9; ++currentDigit) {
            if ((usedDigitsMask & (1 << currentDigit)) == 0 &&
                    currentDigit > lastDigit == shouldIncrement)
                result = Math.min(
                        result,
                        findSmallestNumber(
                                pattern,
                                currentPosition + 1,
                                usedDigitsMask | (1 << currentDigit),
                                currentNum * 10 + currentDigit));
        }
        return result;
    }
}
