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
    int max;
    int sumEndingAt;

    public Pair(int m, int s) {
        this.max = m;
        this.sumEndingAt = s;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        Pair ans = fetch(root);
        return Math.max(ans.max, ans.sumEndingAt);
    }

    public Pair fetch(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Pair(root.val, root.val);
        }
        Pair left = null, right = null;
        if (root.left != null) {
            left = fetch(root.left);
        }
        if (root.right != null) {
            right = fetch(root.right);
        }
        int s = Integer.MIN_VALUE;
        if (left != null) {
            s = Math.max(s, root.val + left.sumEndingAt);
        }
        if (right != null) {
            s = Math.max(s, root.val + right.sumEndingAt);
        }
        s = Math.max(s, root.val);

        int max = Integer.MIN_VALUE;
        if (left != null) {
            max = Math.max(max, left.max);
        }
        if (right != null) {
            max = Math.max(max, right.max);
        }
        if (left != null && right != null) {
            max = Math.max(max, root.val + left.sumEndingAt + right.sumEndingAt);
        }
        max = Math.max(s, max);
        return new Pair(max, s);
    }
}
