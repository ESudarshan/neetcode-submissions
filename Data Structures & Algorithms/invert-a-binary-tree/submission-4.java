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
    public TreeNode invertTree(TreeNode root) {
/*        
        if(root == null) {
            return null;
        }
        TreeNode invertedLeft = invertTree(root.left);
        TreeNode invertedRight = invertTree(root.right);
        root.left = invertedRight;
        root.right = invertedLeft;
        return root;
*/
/*      DFS
        if(root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
*/

/*      BFS
        if(root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode r = q.poll();
            TreeNode temp = r.left;
            r.left = r.right;
            r.right = temp;

            if(r.left != null) {
                q.offer(r.left);
            }

            if(r.right != null) {
                q.offer(r.right);
            }
        }
        return root;
*/
        if(root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode r = stack.pop();
            TreeNode temp = r.left;
            r.left = r.right;
            r.right = temp;
            if(r.left != null) {
                stack.push(r.left);
            }
            if(r.right != null) {
                stack.push(r.right);
            }
        }
        return root;
    }
}
