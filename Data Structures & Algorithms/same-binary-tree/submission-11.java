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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {p, q});

        while(!stack.isEmpty()) {
            TreeNode[] n = stack.pop();
            TreeNode pn = n[0];
            TreeNode qn = n[1];

            if(pn == null && qn == null) {
                continue;
            }

            if(pn == null || qn == null || qn.val != pn.val) {
                return false;
            } 
                
            stack.push(new TreeNode[] {pn.left, qn.left});
            stack.push(new TreeNode[] {pn.right, qn.right});
        }

        return true;
    }
}
