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
         System.out.println(str);
        int n = str.length();
        int end = 0;
        while(end < n) {
            int start=end;
            while(str.charAt(end) != '#') {
                end++;
            }
            int len = Integer.parseInt(str.substring(start, end));
            System.out.println(start);
            System.out.println(end);
            System.out.println(len);
            start = end+1;
            end = start+len;
            System.out.println(start);
            System.out.println(end);
            String word = str.substring(start, end);
            System.out.println(word);
            decoded.add(word);
        }

        return decoded;
    }
}
