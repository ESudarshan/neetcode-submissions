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
    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        dfs(root, isBalanced);
        return isBalanced[0];
    }

    int dfs(TreeNode root, boolean[] isBalanced) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left, isBalanced);
        int right = dfs(root.right, isBalanced);
        isBalanced[0] = isBalanced[0] && (Math.abs(left - right) <= 1) ? true : false;
        return 1 + Math.max(left, right);
    }
}
