class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += countPalindromes(s, i, i, n);
            count += countPalindromes(s, i, i + 1, n);   
        }
        return count;
    }

    public int countPalindromes(String s, int start, int end, int n) {
        int count = 0;
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
