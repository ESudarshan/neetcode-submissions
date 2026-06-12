class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for(char tCh : t.toCharArray()) {
            tMap.put(tCh, tMap.getOrDefault(tCh, 0) + 1);
        }

        int ansLen = s.length() + 1;
        int start = -1;
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
                        start = i;
                    }

                }
            }
        }
        return start == -1 ? "" : s.substring(start, start + ansLen);
        
    }
}
