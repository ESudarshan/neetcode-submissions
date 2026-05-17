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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == q.val) {
            return p;
        }
        if(p.val == root.val) {
            return p;
        }
        if(q.val == root.val) {
            return q;
        }
        if((p.val < root.val && q.val > root.val)
            || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        if(root.left != null && p.val < root.val && q.val < root.val) {
            return lca(root.left, p, q);
        }
        return lca(root.right, p, q);
    }
}
