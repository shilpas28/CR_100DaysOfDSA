//GFG
//Print Bracket Number
//Time complexity: O(|str|)
//Space complexity: O(|str|)

import java.util.ArrayList;
import java.util.Stack;

public class PrintBracketNumber {

    public static void main(String[] args) {
        String str = "(aa(bdc))p(dee)";
        System.out.println(bracketNumbers(str));
    }

    static ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
                ans.add(count);
                st.push(count);
            } else if (str.charAt(i) == ')') {
                ans.add(st.peek());
                st.pop();
            }
        }
        return ans;
    }
}
