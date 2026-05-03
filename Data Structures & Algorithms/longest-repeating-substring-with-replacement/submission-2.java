class Solution {
    public int characterReplacement(String s, int k) {
        /*
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(int j=i; j<n; j++) {
                int freq = map.getOrDefault(s.charAt(j), 0) + 1;
                map.put(s.charAt(j), freq);
                maxFreq =  Math.max(maxFreq, freq);
                int len = j-i+1;
                if(len - maxFreq <= k) {
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
        */

        int n = s.length();
        int ans = 0;
        int l=0;
        int[] charCount =  new int[26];
        int maxFreq = 0;
        for(int r=0; r<n; r++) {
            charCount[s.charAt(r)-'A'] = charCount[s.charAt(r)-'A'] + 1;
            maxFreq = Math.max(maxFreq, charCount[s.charAt(r)-'A']);

            while(r-l+1-maxFreq > k) {
                charCount[s.charAt(l)-'A'] = charCount[s.charAt(l)-'A'] - 1;
                l++;
            }

            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
