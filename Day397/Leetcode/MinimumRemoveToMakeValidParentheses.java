//Leetcode
//1249. Minimum Remove to Make Valid Parentheses - Using Stack
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch))
                continue;
            if(ch == '(')
                stack.push(i);
            else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else stack.push(i);
            }
        }
        // if(stack.size() == 0) return "";
        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for(int i=0;i<s.length();i++)
            if(!set.contains(i))
                result.append(s.charAt(i));
        
        return result.toString();
    }
}
