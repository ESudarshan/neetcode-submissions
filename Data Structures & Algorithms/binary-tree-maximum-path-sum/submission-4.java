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

    Integer maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {      
        pathSum(root);
        return maxPathSum;
    }

    public int pathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftSum = Math.max(0, pathSum(root.left));
        int rightSum = Math.max(0, pathSum(root.right));

        maxPathSum = Math.max(maxPathSum, root.val + leftSum + rightSum);

        int maxSum = root.val + Math.max(leftSum, rightSum);

        return maxSum;
    }
}
