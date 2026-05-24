/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        return clone(node);
    }

    public Node clone(Node root) {
        Queue<Node> q = new LinkedList<>();
        map.put(root, new Node(root.val)); 
        q.offer(root);
        while(!q.isEmpty()) {
            Node node = q.poll();
            Node cloneNode = map.get(node);
            for(Node neighbor : node.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                cloneNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(root);
    }

}