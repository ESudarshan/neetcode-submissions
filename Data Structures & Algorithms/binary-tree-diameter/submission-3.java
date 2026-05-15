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

    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int diameter = height(root.left) + height(root.right);
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right));
        return diameter;
  

    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        d = Math.max(d, lh + rh);
        return 1 + Math.max(lh, rh);
    }
    
}
