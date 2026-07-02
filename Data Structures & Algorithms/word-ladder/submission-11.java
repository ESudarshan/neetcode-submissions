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
        
        Map<String, List<String>> wordPatternMap = new HashMap<>();
        Map<String, List<String>> patternWordMap = new HashMap<>();
        
        for(String word : wordSet) {
            List<String> patterns = new ArrayList<>();
            for(int i=0; i<word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                patterns.add(pattern);
                patternWordMap.putIfAbsent(pattern, new ArrayList<>());
                patternWordMap.get(pattern).add(word);
            }
            wordPatternMap.put(word, patterns);
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordSet.remove(beginWord);
        int l = 1;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                String frontWord  = q.remove();
                if(frontWord.equals(endWord)) {
                    return l;
                }
                for(String pattern : wordPatternMap.get(frontWord)) {
                    for(String word : patternWordMap.get(pattern)) {
                        if(wordSet.contains(word)) {
                            q.add(word);
                            wordSet.remove(word);
                        }
                    }    
                }
            }
            l++;
        }
        return 0;
    }
}
