/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    int height;
    boolean balanced;
    public Pair(int h, boolean b) {
        this.height = h;
        this.balanced = b;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return fetch(root).balanced;
    }

    public Pair fetch(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair left = fetch(root.left);
        if (!left.balanced) {
            return new Pair(-1, false);
        }
        Pair right = fetch(root.right);
        if (!right.balanced) {
            return new Pair(-1, false);
        }
        boolean isBalanced = Math.abs(left.height - right.height) <= 1 ? true : false;
        return new Pair(Math.max(left.height, right.height) + 1, isBalanced);
    }
}
