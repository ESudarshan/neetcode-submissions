class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Map<Character, Integer> sMap = new HashMap();

        for(Character sChar : sArray) {
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
        }

        for(Character tChar : tArray) {
            Integer sFreq = sMap.get(tChar);
            if(sFreq == null) {
                return false;
            } else if(sFreq == 1) {
                sMap.remove(tChar);
            } else {
                sMap.put(tChar, sFreq -1);
            }            
        }

        return sMap.isEmpty();

    }
}
