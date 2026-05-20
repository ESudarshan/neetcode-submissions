class Solution {

    TrieNode root = new TrieNode();

    public void addWords(String[] words) {
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            for(char ch : word.toCharArray()) {
                if(!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.eow = true;
            curr.index = i;
        }
    } 

    public List<String> findWords(char[][] board, String[] words) {
        addWords(words);
        int r = board.length;
        int c = board[0].length;
        List<String> output = new ArrayList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                dfs(board, i, j, r, c, root, words, output);
            }
        }
        return output;
    }

    public void dfs(char[][] board, int ri, int ci, int r, int c, TrieNode root, String[] words, List<String> output) {
        if(ri < 0 || ri >= r || ci < 0 || ci >= c) {
            return;
        }
        if(!root.children.containsKey(board[ri][ci])) {
            return;
        }
        root = root.children.get(board[ri][ci]);
        if(root.eow) {
            output.add(words[root.index]);
            root.eow = false;
        }
        char temp = board[ri][ci];
        board[ri][ci] = '*';
        dfs(board, ri-1, ci, r, c, root, words, output);
        dfs(board, ri+1, ci, r, c, root, words, output);
        dfs(board, ri, ci-1, r, c, root, words, output);
        dfs(board, ri, ci+1, r, c, root, words, output);
        board[ri][ci] = temp;
    }

}


class TrieNode {
    Map<Character, TrieNode> children;
    boolean eow;
    int index;

    public TrieNode() {
        children = new HashMap<>();
        eow = false;
        index = -1;
    }

}