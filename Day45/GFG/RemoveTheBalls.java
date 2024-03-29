//GFG
//Remove The Balls
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class RemoveTheBalls {

    public static void main(String[] args) {
        int N = 3;
        int[] color = { 2, 2, 5 };
        int[] radius = { 3, 3, 4 };
        System.out.println(finLength(N, color, radius));
    }

    static class Pair {
        int color;
        int radius;

        Pair(int color, int radius) {
            this.color = color;
            this.radius = radius;
        }
    }

    public static int finLength(int N, int[] color, int[] radius) {
        // code here
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek().color == color[i] && stack.peek().radius == radius[i])
                    stack.pop();
                else
                    stack.add(new Pair(color[i], radius[i]));
            } else
                stack.add(new Pair(color[i], radius[i]));
        }
        return stack.size();
    }
}
