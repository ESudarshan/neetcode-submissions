class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();

        int[] map = new int[26];
        for(int i=0; i<n; i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        
        int i = 0;
        while(i < n) {
            int start = i;
            int end = i;
            while(start <= end) {
                end = Math.max(end, map[s.charAt(start) - 'a']);
                start++;
            }
            int len = end - i + 1;
            res.add(len);
            i = start;
        }

        return res;
    }
}
