class PrefixTree {

    Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> children;
    boolean eow;

    Node() {
        children = new HashMap<>();
        eow = false;
    }
}