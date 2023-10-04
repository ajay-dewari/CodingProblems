package tree;

public class Tree {

    public class TreeNode {
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

    /**
     * 226. {@link <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>}
     * Given the root of a binary tree, invert the tree, and return its root.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * Example 2:
     * <p>
     * <p>
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     * Example 3:
     * <p>
     * Input: root = []
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 104. {@link <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>}
     * Given the root of a binary tree, return its maximum depth.
     * <p>
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     * Example 2:
     * <p>
     * Input: root = [1,null,2]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 104].
     * -100 <= Node.val <= 100
     **/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 543. {@link <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">Diameter of Binary Tree</a>}
     * Given the root of a binary tree, return the length of the diameter of the tree.
     * <p>
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     * <p>
     * The length of a path between two nodes is represented by the number of edges between them.
     * <p>
     * Example 1:
     * Input: root = [1,2,3,4,5]
     * Output: 3
     * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
     * <p>
     * Example 2:
     * Input: root = [1,2]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [1, 104].
     * -100 <= Node.val <= 100
     * <p>
     **/
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int rootDiameter = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(leftDiameter, Math.max(rightDiameter, rootDiameter));
    }
}