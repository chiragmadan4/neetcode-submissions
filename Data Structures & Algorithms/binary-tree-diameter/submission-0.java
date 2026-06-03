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
    int diameter;
    int height;
    public Pair(int d, int h) {
        this.diameter = d;
        this.height = h;
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        Pair ans = fetch(root);
        return ans.diameter;
    }

    public Pair fetch(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = fetch(root.left);
        Pair right = fetch(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(left.diameter, 
            Math.max(right.diameter, left.height + right.height));
        Pair ans = new Pair(diameter, height);
        return ans;
    }
}
