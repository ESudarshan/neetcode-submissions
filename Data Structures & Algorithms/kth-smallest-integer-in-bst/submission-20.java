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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        dfs(root, ans, k);
        return ans[1];
    }

    public void dfs(TreeNode root, int[] ans, int k) {
        if(root == null) {
            return;
        }
        if(ans[0]<k)
        dfs(root.left, ans, k);
        ans[0]++;
        if(ans[0] == k) {
            ans[1] = root.val;
            return;
        }
        if(ans[0]<k)
        dfs(root.right, ans, k);
    }
}
