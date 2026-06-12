class Solution {
    public int characterReplacement(String s, int k) {
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
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
