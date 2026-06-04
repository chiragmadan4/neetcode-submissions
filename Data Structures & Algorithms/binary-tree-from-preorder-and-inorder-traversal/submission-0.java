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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        TreeNode root = new TreeNode(preorder[l1]);
        int x = -1;
        for (int i = l2; i <= r2; i++) {
            if (inorder[i] == root.val) {
                x = i;
                break;
            }
        }
        int countLeft = x - l2;
        int countRight = r2 - x;
        if (countLeft > 0) {
            root.left = build(preorder, inorder, l1 + 1, l1 + countLeft, l2, x - 1);
        }
        if (countRight > 0) {
            root.right = build(preorder, inorder, l1 + countLeft + 1, r1, x + 1, r2);
        }
        return root;
    }
}
