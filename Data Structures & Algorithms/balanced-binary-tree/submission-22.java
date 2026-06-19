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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        Map<TreeNode, Integer> visited = new HashMap<>();
        visited.put(null, 0);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node.left != null && !visited.containsKey(node.left)) {
                stack.push(node.left);
            } else if(node.right != null && !visited.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int lh = visited.get(node.left);
                int rh = visited.get(node.right);
                if(Math.abs(lh - rh) > 1) {
                    return false;
                }
                int h = 1 + Math.max(lh, rh);
                visited.put(node, h);
            }
        }

        return true;
    }
}
