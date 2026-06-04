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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1, ans);
        }
        if (root.left != null) {
            dfs(root.left, depth + 1, ans);
        }
    }
}
