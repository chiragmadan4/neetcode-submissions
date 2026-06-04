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
    public int goodNodes(TreeNode root) {
        return gn(root, -101);
    }

    public int gn(TreeNode root, int max) {
        int ans = 0;
        if (root.val >= max) {
            ans++;
        }
        if (root.left != null) {
            ans += gn(root.left, Math.max(max, root.val));
        }
        if (root.right != null) {
            ans += gn(root.right, Math.max(max, root.val));
        }
        return ans;
    }
}
