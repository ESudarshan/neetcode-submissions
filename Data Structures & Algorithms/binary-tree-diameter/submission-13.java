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

    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, int[]> visited = new HashMap<>();
        visited.put(null, new int[] {0, 0});
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
                int[] left = visited.get(node.left);
                int[] right = visited.get(node.right);
                int h = 1 + Math.max(left[0], right[0]);
                int d = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
                visited.put(node, new int[] {h, d});
            }
        }

        return visited.get(root)[1];
    }


}
