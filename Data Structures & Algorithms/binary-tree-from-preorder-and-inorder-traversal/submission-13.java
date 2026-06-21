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
        return build(preorder, 0, n-1);
    }

    public TreeNode build(int[] preorder, int il, int ir) {
        if(il > ir) {
            return null;
        }
        int val = preorder[pi++];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        root.left = build(preorder, il, index-1);
        root.right = build(preorder, index+1, ir);
        return root;
    }

}
