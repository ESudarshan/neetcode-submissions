class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int[] map = new int[26];
        Arrays.fill(map, 0);
        for(int i=0; i<n; i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        
        int i=0;
        while(i < n) {
            int lastIndex = map[s.charAt(i) - 'a'];
            int j = i;
            while(j <= lastIndex) {
                lastIndex = Math.max(lastIndex, map[s.charAt(j) - 'a']);
                j++;
            }
            res.add(j - i);
            i = j;
        }
        return res;
    }
}
