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
    boolean isBST;
    int min;
    int max;
    public Pair(boolean v, int min, int max) {
        this.isBST = v;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    int max = -2000;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        // return check(root).isBST;
        traverse(root);
        return isValid;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (root.val <= max) {
            isValid = false;
        }
        max = Math.max(max, root.val);
        traverse(root.right);
    }

    public Pair check(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Pair(true, root.val, root.val);
        }
        Pair left = null, right = null;
        if (root.left != null) {
            left = check(root.left);
            if (!left.isBST) {
                return new Pair(false, -1, -1);
            }
        }
        if (root.right != null) {
            right = check(root.right);
            if (!right.isBST) {
                return new Pair(false, -1, -1);
            }
        }
        boolean isValid = true;
        if (left != null) {
            if (root.val <= left.max) {
                isValid = false;
            }
        }
        if (right != null) {
            if (root.val >= right.min) {
                isValid = false;
            }
        }
        if (!isValid) {
            return new Pair(false, -1, -1);
        }
        
        return new Pair(true, left != null ? left.min : root.val, right != null ? right.max : root.val);
    }
}
