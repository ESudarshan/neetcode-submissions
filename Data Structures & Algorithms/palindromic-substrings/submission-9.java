class Solution {

    int count = 0;
    public int countSubstrings(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            countPalindromes(s, i, i, n);
            countPalindromes(s, i, i + 1, n);   
        }
        return count;
    }

    public int countPalindromes(String s, int start, int end, int n) {
        while(start >= 0 && end < n) {
            if(s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
            count++;
        }
        return count;
    }
}
