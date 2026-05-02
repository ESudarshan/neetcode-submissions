class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i <= j) {
            if(!Character.isLetterOrDigit(charArray[i])) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(charArray[j])) {
                j--;
                continue;
            }
            char left = charArray[i];
            char right = charArray[j];
            if(Character.toUpperCase(left) != Character.toUpperCase(right)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
