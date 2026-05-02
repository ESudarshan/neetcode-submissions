class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();

        for(String str : strs) {
            char[] strArray = str.toCharArray();
            int[] az = new int[26];
            for(char c : strArray) {
                az[c-'a']++;
            }
            String key = Arrays.toString(az);
            ans.putIfAbsent(key, new ArrayList<>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
