class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(int i=0; i< strs.size(); i++) {
            encoded += strs.get(i);
            encoded += "🙂";
        }
        return encoded;
    }

    public List<String> decode(String str) {
        if(str.isEmpty()) {
            return new ArrayList();
        }
        String[] split = str.split("🙂", -1);
        return Arrays.asList(split).subList(0, split.length-1);
    }
}
