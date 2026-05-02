class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i <= j) {
            if(!isAlphanumeric(charArray[i])) {
                i++;
                continue;
            }
            if(!isAlphanumeric(charArray[j])) {
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

    public boolean isAlphanumeric(char ch) {
        if(('a' <= ch && ch <='z')
           || ('A' <= ch && ch <='Z')
           || ('0' <= ch && ch <='9')) {
            System.out.println(ch + "- true");
            return true;
        }
        return false;
    }
}
