class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder("");
        for(int i=0; i< strs.size(); i++) {
            encoded.append(strs.get(i).length());
            encoded.append("#");
            encoded.append(strs.get(i));
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int n = str.length();
        int end = 0;
        while(end < n) {
            int start = end;
            end = str.indexOf('#', start);
            int len = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + len;
            String word = str.substring(start, end);
            decoded.add(word);
        }

        return decoded;
    }
}
