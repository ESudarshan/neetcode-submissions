class Solution {
    public String minWindow(String s, String t) {
/*
        Map<Character, Integer> tMap = new HashMap<>();
        for(char tCh : t.toCharArray()) {
            tMap.put(tCh, tMap.getOrDefault(tCh, 0) + 1);
        }

        int ansLen = s.length() + 1;
        String ansStr = "";
        int n = s.length();
        for(int i=0; i<n; i++) {
            Map<Character, Integer> sMap = new HashMap<>();
            for(int j=i; j<n; j++) {
                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
                boolean valid = true;
                for(char ch : tMap.keySet()) {
                    if(!sMap.containsKey(ch) || tMap.get(ch) > sMap.get(ch)) {
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    if(j-i+1 < ansLen) {
                        ansLen = j-i+1;   
                        ansStr = s.substring(i, j+1);
                    }

                }
            }
        }
        return ansStr;
*/
        String ans = "";
        int[] res = new int[2];
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
                    res = new int[] { l, r };
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
            ans = s.substring(res[0], res[1]+1);
        }

        return ans;
    }
}
