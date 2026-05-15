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

    public int diameterOfBinaryTree(TreeNode root) {
/*
        if(root == null) {
            return 0;
        }
        int diameter = height(root.left) + height(root.right);
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right));
        return diameter;
*/  
        int[] d = new int[1];
        dfs(root, d);
        return d[0];
    }

    public int dfs(TreeNode root, int[] d) {
        if(root == null) {
            return 0;
        }
        int lh = dfs(root.left, d);
        int rh = dfs(root.right, d);
        d[0] = Math.max(d[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    
}
