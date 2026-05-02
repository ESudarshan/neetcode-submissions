class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(int i=0; i< strs.size(); i++) {
            encoded += strs.get(i).length();
            encoded += "#";
            encoded += strs.get(i);
        }
        System.out.println(encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        // if(str.isEmpty()) {
        //     return decoded;
        // }
        char[] charArray = str.toCharArray();
        for(int i=0; i<str.length(); i++) {
            String lenStr = "";
            while(charArray[i] != '#') {
                lenStr += charArray[i];
                i++;
            }
            i++;
             System.out.println("i = " + i + " lenStr - " + lenStr);
            int len = Integer.parseInt(lenStr);
            
            decoded.add(str.substring(i, i+len));
            i += len -1;
        }
        return decoded;
    }
}
