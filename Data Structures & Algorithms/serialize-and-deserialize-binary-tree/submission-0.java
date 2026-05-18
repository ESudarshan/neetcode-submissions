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
        List<String> list = new ArrayList<>();
        dfsi(root, list);
        System.out.println(String.join(",", list));
        return String.join(",", list);
    }

    public void dfsi(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsi(root.left, list);
        dfsi(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list =  Arrays.asList(data.split(","));
        return dfso(list, new int[1]);
    }

    public TreeNode dfso(List<String> list, int[] i) {
        if(i[0] >= list.size()) {
            return null;
        }
        String str = list.get(i[0]);
        i[0]++;
        if(str.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfso(list, i);
        node.right = dfso(list, i);
        return node;
    }

}
