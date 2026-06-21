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

    int pi = 0;
    int ii = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return build(preorder, inorder, n, Long.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int[] inorder, int n, long limit) {
        if(pi == n) {
            return null;
        }

        if(inorder[ii] == limit) {
            ii++;
            return null;
        }

        int val = preorder[pi++];
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, inorder, n, val);
        root.right = build(preorder, inorder, n, limit);
        
        return root;
    }

}
