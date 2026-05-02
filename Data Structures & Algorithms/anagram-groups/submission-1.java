class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();

        for(String str : strs) {
            char[] strArray = str.toCharArray();
            int[] az = new int[26];
            for(char c : strArray) {
                az[c-97]++;
            }
            for(int i=0; i<az.length; i++) {
                System.out.print(az[i]);
            }
            System.out.println("");
            String key = Arrays.toString(az);
            ans.putIfAbsent(key, new ArrayList());
            ans.get(key).add(str);
        }
        System.out.println(ans);
        return new ArrayList(ans.values());
    }
}
