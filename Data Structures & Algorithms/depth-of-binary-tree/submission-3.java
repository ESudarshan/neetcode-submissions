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
/*
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
*/

/*      DFS
        if(root == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int max = 1;
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode r = pair.getKey();
            int curr = pair.getValue();
            max = Math.max(max, curr);
            if(r.left != null) {
                stack.push(new Pair<>(r.left, 1 + curr));
            }
            if(r.right != null) {
                stack.push(new Pair<>(r.right, 1 + curr));
            }
        }
        return max;
*/

        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            level++;
            int n = q.size();
            for(int i=0; i<n; i++) {
                TreeNode r = q.poll();
                if(r.left != null) {
                    q.offer(r.left);
                }
                if(r.right != null) {
                    q.offer(r.right);
                }
            }
        }
        return level;
    }
}
