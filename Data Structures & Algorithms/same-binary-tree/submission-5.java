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
/*        
        if(p == null && q == null) {
            return true;
        } 
        if(p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
*/

        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()) {
            TreeNode qn = stack.pop();
            TreeNode pn = stack.pop();
            if((pn == null && qn != null) || (pn != null && qn == null)) {
                return false;
            } else if(pn != null && qn != null) {
                if(pn.val != qn.val) {
                    return false;
                }
                stack.push(pn.left);
                stack.push(qn.left);
                stack.push(pn.right);
                stack.push(qn.right);
            }
        }
        return true;
    }
}
