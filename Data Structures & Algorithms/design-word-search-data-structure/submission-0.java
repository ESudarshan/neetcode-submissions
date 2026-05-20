class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return search(root, word);
    }

    public boolean search(Node root, String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(ch == '.') {
                for(Node node : curr.children.values()) {
                    if(search(node, word.substring(word.indexOf(ch)+1))) {
                        return true;
                    }
                }
                return false;
            }
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.eow;
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
