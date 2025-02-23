//Leetcode
//889. Construct Binary Tree from Preorder and Postorder Traversal - Using Index Array
//Time complexity: O(N)
//Space complexity: O(N)

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_2 {

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
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode res = constructFromPrePost(preorder, postorder);
        printInorder(res);
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;
        // Create the index array for `postorder`
        int[] indexInPostOrder = new int[numOfNodes + 1];
        for (int index = 0; index < numOfNodes; index++) {
            // Store the index of the current element
            indexInPostOrder[postorder[index]] = index;
        }
        return constructTree(0, numOfNodes - 1, 0, preorder, indexInPostOrder);
    }

    // Helper function to construct the tree recursively
    static TreeNode constructTree(
            int preStart,
            int preEnd,
            int postStart,
            int[] preorder,
            int[] indexInPostOrder) {
        // Base case: If there are no nodes to process, return null
        if (preStart > preEnd)
            return null;
        // Base case: If only one node is left, return that node
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        // The left child root in preorder traversal (next element after root)
        int leftRoot = preorder[preStart + 1];
        // Calculate the number of nodes in the left subtree by searching in postorder
        int numOfNodesInLeft = indexInPostOrder[leftRoot] - postStart + 1;

        TreeNode root = new TreeNode(preorder[preStart]);
        // Recursively construct the left subtree
        root.left = constructTree(
                preStart + 1,
                preStart + numOfNodesInLeft,
                postStart,
                preorder,
                indexInPostOrder);
        // Recursively construct the right subtree
        root.right = constructTree(
                preStart + numOfNodesInLeft + 1,
                preEnd,
                postStart + numOfNodesInLeft,
                preorder,
                indexInPostOrder);

        return root;
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
