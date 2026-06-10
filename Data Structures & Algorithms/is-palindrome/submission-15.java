class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb =  new StringBuilder("");
        for(int i=0; i<n; i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String og = sb.toString();
        String reversed = new StringBuilder(og).reverse().toString();
        return og.equals(reversed);
    }

}
