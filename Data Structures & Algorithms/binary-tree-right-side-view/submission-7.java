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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        dfs(root, 0, list);
        return list;    
    }

    public void dfs(TreeNode root, int l, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(list.size() == l) {
            list.add(root.val);
        }
        
        list.set(l, root.val);
        
        dfs(root.left, l+1, list);
        dfs(root.right, l+1, list);
    }

}
