class Solution {

    int[] mem;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        mem = new int[n];
        Arrays.fill(mem, -1);
        return breakWord(s, 0, n, wordDict);
    }

    public boolean breakWord(String s, int start, int n, List<String> wordDict) {
        if(start == n) {
            return true;
        }
        if(mem[start] != -1) {
            return mem[start] == 0 ? false : true;
        }
        for(String dWord : wordDict) {
            int wi = start;
            int dwi = 0;
            while(dwi < dWord.length() && wi < n) {
                if(dWord.charAt(dwi) != s.charAt(wi)) {
                    break;
                }
                dwi++;
                wi++;
            }
            if(dwi != dWord.length()) {
                continue;
            }
            if(breakWord(s, wi, n, wordDict)) {
                return true;
            }
        }
        mem[start] = 0;
        return false;
    }

}
