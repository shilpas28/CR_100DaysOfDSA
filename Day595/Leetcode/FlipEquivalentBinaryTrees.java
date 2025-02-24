//Leetcode
//951. Flip Equivalent Binary Trees - Recursive DFS 
//Time complexity: O(N^2)
//Space complexity: O(N) 

public class FlipEquivalentBinaryTrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        System.out.println(flipEquiv(root1, root2));
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        return root1.val == root2.val &&
                (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
