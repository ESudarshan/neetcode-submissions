class Solution {
    public int lengthOfLongestSubstring(String s) {
/*
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            Set<Character> seen = new HashSet<>();
            for(int j=i; j<n; j++) {
                if(seen.contains(s.charAt(j))) {
                    break;
                }
                seen.add(s.charAt(j));
                ans = Math.max(ans, j-i+1);
            }
        }
        return ans;
*/

        int n = s.length();
        if(n == 1) {
            return 1;
        }
        int ans = 0;
        Set<Character> seen = new HashSet<>();
        int l = 0;
        int r = 0;
        int len = 0;
        while (r < n) {
            if(!seen.contains(s.charAt(r))) {
                len++;
                ans = Math.max(ans, len);
                seen.add(s.charAt(r));
                r++;
            } else {
                len = 0;
                seen.clear();
                l++;
                r = l;
            }
        }

        return ans;

    }
}
