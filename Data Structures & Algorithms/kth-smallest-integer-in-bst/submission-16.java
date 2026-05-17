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
/*
        int[] ans = new int[2];
        ans[0] = k;
        dfs(root, ans);
        return ans[1];
*/
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode n = stack.pop();
            k--;
            if(k == 0) {
                return n.val;
            }
            curr = n.right;
        }
        return -1;
    }

    public void dfs(TreeNode root, int[] ans) {
        if(root == null) {
            return;
        }
        dfs(root.left, ans);
        if(ans[0] == 0) {
            return;
        }
        ans[0]--;
        if(ans[0] == 0) {
            ans[1] = root.val;
            return;
        }
        dfs(root.right, ans);
    }

}
