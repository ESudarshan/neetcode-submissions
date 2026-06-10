class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb =  new StringBuilder("");
        for(int i=0; i<n; i++) {
            if(isAlphaNumeric(s, i)) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    boolean isAlphaNumeric(String s, int i) {
        if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
            || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return true;
            }
        return false;
    }
}
