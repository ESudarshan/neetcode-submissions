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
        Queue<String> queue =  new LinkedList<>(Arrays.asList(data.split(",")));
        return dfso(queue);
    }

    public TreeNode dfso(Queue<String> queue) {
        String str = queue.remove();
        if(str.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfso(queue);
        node.right = dfso(queue);
        return node;
    }

}
