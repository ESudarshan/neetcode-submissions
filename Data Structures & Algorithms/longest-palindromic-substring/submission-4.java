class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int maxStart = 0;
        for(int i=0; i<n; i++) {
            int start = i-1;
            int end = i+1;
            int len = 1;
            while(start >= 0 && end<=n-1) {
                if(s.charAt(start) != s.charAt(end)) {
                    break;
                }
                len += 2;
                start--;
                end++;
            }
            if(len > maxLen) {
                maxLen = len;
                maxStart = start+1;
            }
            
            start = i;
            end = i+1;
            len = 0;
            while(start >= 0 && end<=n-1) {
                if(s.charAt(start) != s.charAt(end)) {
                    break;
                }
                len += 2;
                start--;
                end++;
            }
            if(len > maxLen) {
                maxLen = len;
                maxStart = start+1;
            }
        }
        return s.substring(maxStart, maxStart+maxLen);
    }
}
