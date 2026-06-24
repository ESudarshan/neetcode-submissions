class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(Node root, String word, int i) {
        Node curr = root;
        for(int k=i; k<word.length(); k++) {
            char ch = word.charAt(k);
            if(ch != '.') {
                if(curr.children[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.children[ch - 'a'];
            } else {
                for(Node node : curr.children) {
                    if(node != null && search(node, word, k+1)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return curr.eow;
    }
}

class Node {
    Node[] children;
    boolean eow;

    public Node() {
        children = new Node[26];
        eow = false;
    }
}
