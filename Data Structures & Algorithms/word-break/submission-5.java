class Solution {

    int[][] mem;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        mem = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return breakWord(s, 0, 0, n, wordDict);
    }

    public boolean breakWord(String s, int start, int end, int n, List<String> wordDict) {
        if(start == n) {
            return true;
        }

        if(end == n) {
            return false;
        }

        if(mem[start][end] != -1) {
            return mem[start][end] == 0 ? false : true;
        }

        boolean res = false;
        if(wordDict.contains(s.substring(start, end + 1))) {
            res = breakWord(s, end + 1, end + 1, n, wordDict);
        }
        res = res || breakWord(s, start, end + 1, n, wordDict);
        mem[start][end] = res == false ? 0 : 1;
        return res;
    }

}
