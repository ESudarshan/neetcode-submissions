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
    Map<Integer, Integer> map = new HashMap<>();
    int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {    
        int n = preorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int i1, int i2) {
        if(i1 > i2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p]);
        int i = map.get(preorder[p]);
        p++;
        root.left = buildTree(preorder, inorder, i1, i-1);
        root.right = buildTree(preorder, inorder, i+1, i2);
        return root;
    }
}
