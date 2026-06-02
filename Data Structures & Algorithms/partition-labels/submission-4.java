class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();

        int[] map = new int[26];
        for(int i=0; i<n; i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        
        int end = 0;
        int size = 0;
        for(int i=0; i<n; i++) {
            size++;
            end = Math.max(end, map[s.charAt(i) - 'a']);
            if(i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
