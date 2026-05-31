class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            while(start >= 0 && end < n) {
                if(s.charAt(start) != s.charAt(end)) {
                    break;
                }
                start--;
                end++;
                count++;
            }
            start = i;
            end = i + 1;
            while(start >= 0 && end < n) {
                if(s.charAt(start) != s.charAt(end)) {
                    break;
                }
                start--;
                end++;
                count++;
            }
        }
        return count;
    }
}
