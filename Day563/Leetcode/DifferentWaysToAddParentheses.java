//Leetcode
//241. Different Ways to Add Parentheses - Recursion 
//Time complexity: O(2^n) Exponential, it's very hard to derive exact Time complexity of the solution but it will be 
//definitely exponential in nature.
//Space complexity: O(n * x) for recursion stack. where, x is the number of ways to calcuate the expression which is operators!

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return getDiffWays(0, n - 1, expression);
    }

    static List<Integer> getDiffWays(int i, int j, String expression) {
        int len = j - i + 1;
        List<Integer> res = new ArrayList<>();
        // If length of the substring is 1 or 2
        // we encounter our base case i.e. a number found.
        if (len <= 2) {
            res.add(Integer.parseInt(expression.substring(i, i + len)));
            return res;
        }
        // If it is not a number then it is an expression
        // now we try to evaluate every opertor present in it
        for (int ind = i; ind <= j; ind++) {
            if (isOperator(expression.charAt(ind))) {
                char op = expression.charAt(ind);
                // if char at ind is operator
                // get all results for its left and right substring using recursion
                List<Integer> left = getDiffWays(i, ind - 1, expression);
                List<Integer> right = getDiffWays(ind + 1, j, expression);
                // try all options for left & right operand
                // and push all results to the answer
                for (int l : left) {
                    for (int r : right) {
                        if (op == '+') {
                            res.add(l + r);
                        } else if (op == '-') {
                            res.add(l - r);
                        } else if (op == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*');
    }
}
