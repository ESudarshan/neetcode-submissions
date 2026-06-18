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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            level++;
            int n = q.size();
            for(int i=0; i<n; i++) {
                TreeNode r = q.remove();
                if(r.left != null) {
                    q.add(r.left);
                }
                if(r.right != null) {
                    q.add(r.right);
                }
            }
        }
        return level;        
    }
}
