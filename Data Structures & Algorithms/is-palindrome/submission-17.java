class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(Character.toUpperCase(left) != Character.toUpperCase(right)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
