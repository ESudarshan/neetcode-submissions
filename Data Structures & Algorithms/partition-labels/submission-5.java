class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(s.charAt(i), i);
        }
        
        int i=0;
        while(i < n) {
            int lastIndex = map.get(s.charAt(i));
            int j = i;
            while(j <= lastIndex) {
                lastIndex = Math.max(lastIndex, map.get(s.charAt(j)));
                j++;
            }
            res.add(j - i);
            i = j;
        }
        return res;
    }
}
