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
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, -101));
        while(!q.isEmpty()) {
            for(int i=0; i<q.size(); i++) {
                Pair<TreeNode, Integer> pair = q.remove();
                int max = pair.getValue(); 
                TreeNode node = pair.getKey();
                if(node.val >= max) {
                    max = node.val;
                    count++;
                }
                if(node.left != null) {
                    q.add(new Pair<>(node.left, max));
                }
                if(node.right != null) {
                    q.add(new Pair<>(node.right, max));
                }
            }
        }
        return count;
    }
}
