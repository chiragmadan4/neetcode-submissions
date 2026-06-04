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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return lca(root, min, max);
    }

    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val > p && root.val < q) {
            return root;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        if (left != null) {
            return left;
        }
        TreeNode right = lca(root.right, p, q);
        if (right != null) {
            return right;
        }
        return null;
    }
}
