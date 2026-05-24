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

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if(node == null) {
            return null;
        }

        if(map.containsKey(node.val)) {
            return map.get(node.val);
        } 
        
        Node cloneNode = new Node(node.val);
        map.put(cloneNode.val, cloneNode);
        
        List<Node> cloneNeighbors = new ArrayList<>();
        for(Node neighbor : node.neighbors) {
            cloneNeighbors.add(clone(neighbor));
        }
        cloneNode.neighbors = cloneNeighbors;
        return cloneNode;
    }


}