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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node == null) {
                sb.append("N,");
                continue;
            }
            sb.append(node.val);
            sb.append(",");
            q.add(node.left);
            q.add(node.right);
        }   
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) {
            return null;
        }
        String[] values =data.split(",");
        int i = 0;
        if(values[i].equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[i]));
        i++;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(!values[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.left);
            }
            i++;
            if(!values[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}
