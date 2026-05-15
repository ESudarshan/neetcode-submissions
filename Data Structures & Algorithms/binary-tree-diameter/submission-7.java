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
/*
        if(root == null) {
            return 0;
        }
        int diameter = dfsi(root.left) + dfsi(root.right);
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right));
        return diameter;
*/
 
        int[] d = new int[1];
        dfs(root, d);
        return d[0];        
    }

    public int dfs(TreeNode root, int[] d) {
        if(root == null) {
            return 0;
        }
        int lh = dfs(root.left, d);
        int rh = dfs(root.right, d);
        d[0] = Math.max(d[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    
    public int dfsi(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode r = pair.getKey();
            int h = pair.getValue(); 
            height = Math.max(height, h);
            if(r.left != null) {
                stack.push(new Pair<>(r.left, h + 1));
            }
            if(r.right != null) {
                stack.push(new Pair<>(r.right, h + 1));
            }
        }
        return height;
    }


}
