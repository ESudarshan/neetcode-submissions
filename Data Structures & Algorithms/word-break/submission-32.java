class Solution {

    Boolean[] mem;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        mem = new Boolean[n];
        return wbreak(s, 0, n, wordDict);
    }

    public boolean wbreak(String s, int i, int n, List<String> wordDict) {
        if(i == n) {
            return true;
        }

        if(mem[i] != null) {
            return mem[i];
        }

        for(String word : wordDict) {
            int wl = word.length();
            if(i+wl<=n && word.equals(s.substring(i, i+wl))) {
                if(wbreak(s, i+wl, n, wordDict)) {
                    // mem[]
                    return true;
                }
            }
        }

        mem[i] = false;
        return false;
     }

}
