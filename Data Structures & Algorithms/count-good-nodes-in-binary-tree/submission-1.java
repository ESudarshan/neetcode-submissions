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
        return dfs(root, Long.MIN_VALUE);
    }

    int dfs(TreeNode root, long max) {
        if(root == null) {
            return 0;
        }
        if(root.val >= max) {
            max = root.val;
            return 1 + dfs(root.left, max) + dfs(root.right, max);
        } else {
            return dfs(root.left, max) + dfs(root.right, max);
        }
    }
    
}
