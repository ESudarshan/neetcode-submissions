class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
            return 1;
        }

        if(!wordList.contains(endWord)) {
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

                char[] charArray = word.toCharArray();
                for(int j=0; j<charArray.length; j++) {
                    char og = charArray[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(charArray[j] == ch) {
                            continue;
                        }
                        charArray[j] = ch;
                        String nei = new String(charArray);
                        if(wordSet.contains(nei)) {
                            q.add(nei);
                            wordSet.remove(nei);
                        }
                    }
                    charArray[j] = og;
                }
            }

            level++;
        }

        return 0;
    }
}