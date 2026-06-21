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

    HashMap<Integer, Integer> map = new HashMap<>();
    int pi = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int ii, int ij) {
        if(ii > ij) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pi]);
        int index = map.get(preorder[pi]);
        pi++;
        root.left = build(preorder, inorder, ii, index-1);
        root.right = build(preorder, inorder, index+1, ij);
        return root;
    }

}
