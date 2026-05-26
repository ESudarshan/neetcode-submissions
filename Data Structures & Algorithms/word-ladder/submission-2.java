class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);
        for(String word : wordList) {
            wordSet.add(word);
        }
        
        Map<String, List<String>> wordPatternMap = new HashMap<>();
        Map<String, List<String>> patternWordMap = new HashMap<>();
        
        for(String word : wordSet) {
            List<String> patterns = new ArrayList<>();
            for(int i=0; i<word.length(); i++) {
                StringBuilder patternBuilder = new StringBuilder(word);
                patternBuilder.setCharAt(i, '*');
                String pattern = patternBuilder.toString();
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
                    System.out.println(frontWord);
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
