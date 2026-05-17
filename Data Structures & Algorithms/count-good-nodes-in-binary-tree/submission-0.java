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
        int[] count = new int[1];
        dfs(root, Long.MIN_VALUE, count);
        return count[0];
    }

    void dfs(TreeNode root, long max, int[] count) {
        if(root == null) {
            return;
        }
        if(root.val >= max) {
            max = root.val;
            count[0]++;
        }
        dfs(root.left, max, count);
        dfs(root.right, max, count);
    }

}
