class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap();
        for(int i=0; i<s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tMap = new HashMap();
        for(int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        if(sMap.size() != tMap.size()) {
            return false;
        }

        for(char key : sMap.keySet()) {
            if(!tMap.containsKey(key) || !sMap.get(key).equals(tMap.get(key))) {
                return false;
            }
        }

        return true;
    }
}
