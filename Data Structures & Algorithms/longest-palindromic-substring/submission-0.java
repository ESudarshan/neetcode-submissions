class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] coordinates = new int[2];
        int maxL = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalindrome(s, i, j) && (j-i+1) > maxL) {
                    maxL = j-i+1;
                    coordinates = new int[] {i, j};
                }
            }
        }
        return s.substring(coordinates[0], coordinates[1] + 1);
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
