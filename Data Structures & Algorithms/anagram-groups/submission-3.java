class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), (k) -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
