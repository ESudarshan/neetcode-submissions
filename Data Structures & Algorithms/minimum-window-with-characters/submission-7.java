class Solution {
    public String minWindow(String s, String t) {

        String ans = "";
        int start = -1;
        int resLen = Integer.MAX_VALUE;

        if(t.isEmpty()) {
            return ans;
        }

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char tCh : t.toCharArray()) {
            tMap.put(tCh, 1 + tMap.getOrDefault(tCh, 0));
        }

        int l = 0;
        int have = 0;
        int need = tMap.size();

        for(int r=0; r<s.length(); r++) {
            char rChar = s.charAt(r);
            window.put(rChar, 1 + window.getOrDefault(rChar, 0));
            
            if(tMap.containsKey(rChar) && tMap.get(rChar) == window.get(rChar)) {
                have++;
            }

            while(have == need) {
                if(r-l+1 < resLen) {
                    start = l;
                    resLen = r-l+1;
                }
                char lChar = s.charAt(l);
                window.put(lChar, window.get(lChar) - 1);
                if(tMap.containsKey(lChar) && window.get(lChar) < tMap.get(lChar)) {
                    have--;
                }
                l++;  
            }
        }

        if(resLen < Integer.MAX_VALUE) {
            ans = s.substring(start, start + resLen);
        }

        return ans;
    }
}
