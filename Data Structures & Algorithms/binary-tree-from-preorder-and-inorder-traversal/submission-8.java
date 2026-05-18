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
    public TreeNode buildTree(int[] preorder, int[] inorder) {    
        int n = inorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n-1, 0, n-1);
    }

    public TreeNode buildTree(int[] preorder, int p1, int p2, int i1, int i2) {
        if(p1 > p2 || i1 > i2) {
            return null;
        }
        int val = preorder[p1];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        int leftNodeCount = i - i1;
        root.left = buildTree(preorder, p1+1, p1+leftNodeCount, i1, i-1);
        root.right = buildTree(preorder, p1+leftNodeCount+1, p2, i+1, i2);
        return root;
    }
}
