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
            int start = i;
            int end = i;
            while(start <= end) {
                end = Math.max(end, map.get(s.charAt(start)));
                start++;
            }
            res.add(end - i + 1);
            i = end + 1;
        }
        return res;
    }
}
