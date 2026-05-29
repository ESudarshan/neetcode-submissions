class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1;
        int maxLen = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if((j-i+1) > maxLen && isPalindrome(s, i, j)) {
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        } 
        return true;
    }
}
