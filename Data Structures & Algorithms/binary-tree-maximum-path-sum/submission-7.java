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
    
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) { 
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        res = Math.max(res, root.val + maxFromNode(root.left) + maxFromNode(root.right));
        dfs(root.left);
        dfs(root.right);
    }

    public int maxFromNode(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int max = node.val + Math.max(maxFromNode(node.left), maxFromNode(node.right));
        return Math.max(0, max);
    }

}
