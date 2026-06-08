class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> ans = new HashMap<>();

        for(String str : strs) {
            int m = str.length();
            int[] az = new int[26];
            for(int i=0; i<m; i++) {
                az[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(az);
            ans.putIfAbsent(key, new ArrayList<>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
