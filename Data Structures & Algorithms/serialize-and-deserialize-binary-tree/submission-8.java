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
        dfsi(root, sb);
        return sb.toString();
    }

    public void dfsi(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        dfsi(root.left, sb);
        dfsi(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = new int[1];
        return dfso(data, i);
    }

    public TreeNode dfso(String data, int[] i) {
        if(i[0] >= data.length()) {
            return null;
        }
        int comma = data.indexOf(",", i[0]);
        String token = data.substring(i[0], comma);
        i[0] = comma + 1;
        if(token.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = dfso(data, i);
        node.right = dfso(data, i);
        return node;
    }

}
