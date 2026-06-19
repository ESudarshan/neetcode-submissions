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
    
    int d; 

    public int diameterOfBinaryTree(TreeNode root) {
        d = 0;
        dfs(root);
        return d;        
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        d = Math.max(d, lh + rh);
        return 1 + Math.max(lh, rh);
    }  

}
