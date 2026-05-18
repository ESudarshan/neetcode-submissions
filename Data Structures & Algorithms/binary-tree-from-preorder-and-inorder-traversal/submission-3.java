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
        int n = inorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n-1);
    }

    public TreeNode buildTree(int[] preorder, int i1, int i2) {
        if(i1 > i2) {
            return null;
        }
        int val = preorder[p];
        p += 1;
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        root.left = buildTree(preorder, i1, i-1);
        root.right = buildTree(preorder, i+1, i2);
        return root;
    }
}
