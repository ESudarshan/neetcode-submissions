class Solution {

    int[] mem;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        mem = new int[n];
        Arrays.fill(mem, -1);
        return breakWord(s, 0, n, new HashSet<>(wordDict));
    }

    public boolean breakWord(String s, int start, int n, Set<String> wordDict) {
        if(start == n) {
            return true;
        }
        if(mem[start] != -1) {
            return mem[start] == 0 ? false : true;
        }
        for(int end=start; end<n; end++) {
            if(wordDict.contains(s.substring(start, end + 1))) {
                if(breakWord(s, end + 1, n, wordDict)) {
                    return true;
                }
            }
        }
        mem[start] = 0;
        return false;
    }

}
