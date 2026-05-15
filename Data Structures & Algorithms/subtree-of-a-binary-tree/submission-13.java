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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root == subRoot) {
            return true;
        } 
        if(root == null || subRoot == null) {
            return false;
        }
        if(isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode r1, TreeNode r2) {
        if(r1 == r2) {
            return true;
        }
        if(r1 == null || r2 == null || r1.val != r2.val) {
            return false;
        }
        return isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }
}
