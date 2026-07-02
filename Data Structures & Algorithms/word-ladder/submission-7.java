class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);

        Queue<String> q =  new LinkedList<>();
        q.add(beginWord);
        wordSet.remove(beginWord);

        int level = 1;

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                String word = q.remove();
                if(word.equals(endWord)) {
                    return level;
                }

                for(int j=0; j<word.length(); j++) {
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(word.charAt(j) == ch) {
                            continue;
                        }
                        String nei = word.substring(0, j) + ch + word.substring(j+1);
                        if(wordSet.contains(nei)) {
                            q.add(nei);
                            wordSet.remove(nei);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}