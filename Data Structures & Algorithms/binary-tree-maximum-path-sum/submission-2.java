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
        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);

        int noSplitSum = Math.max(root.val, root.val + leftSum);
        noSplitSum = Math.max(noSplitSum, root.val + rightSum);
        noSplitSum = Math.max(noSplitSum, root.val + leftSum + rightSum);
        maxPathSum = Math.max(maxPathSum, noSplitSum);

        int maxSum = root.val + Math.max(leftSum, rightSum);
        maxSum = Math.max(maxSum, root.val);
        return maxSum;
    }
}
