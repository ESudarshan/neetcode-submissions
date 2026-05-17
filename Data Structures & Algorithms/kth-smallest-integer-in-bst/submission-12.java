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
        dfs(root, k, ans);
        return ans[1];
    }

    public void dfs(TreeNode root, int k, int[] ans) {
        if(root == null) {
            return;
        }
        dfs(root.left, k, ans);
        if(ans[0] == k) {
            return;
        }
        ans[0]++;
        if(ans[0] == k) {
            ans[1] = root.val;
            return;
        }
        dfs(root.right, k, ans);
    }

}
