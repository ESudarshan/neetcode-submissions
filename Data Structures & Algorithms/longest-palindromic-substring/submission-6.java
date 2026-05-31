class Solution {

    int maxLen = 0;
    int maxStart = 0;

    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            palindrome(s, i, i, n);
            palindrome(s, i, i + 1, n);
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public void palindrome(String s, int start, int end, int n) {
        int len = 0;
        while(start >= 0 && end <= n - 1) {
            if(s.charAt(start) != s.charAt(end)) {
                break;
            }
            len = (end - start + 1);
            start--;
            end++;
        }
        if(len > maxLen) {
            maxLen = len;
            maxStart = start + 1;
        }
    }
}
