class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();

        for(String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = String.valueOf(strArray);
            List<String> list = ans.getOrDefault(key, new ArrayList());
            list.add(str);
            ans.put(key, list);
        }

        return new ArrayList(ans.values());
    }
}
