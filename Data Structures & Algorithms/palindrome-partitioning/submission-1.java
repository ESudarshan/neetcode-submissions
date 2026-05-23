class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), output);
        for(int i=0; i<output.size(); i++) {
            List<String> l = output.get(i);
            if(!isListPalindrome(l)) {
                output.remove(i);
            }
        }
        return output;
    }

    public void backtrack(String s, int i, int k, List<String> l, List<List<String>> output) {
        if(k == s.length()) {
            if(i == k) {
                output.add(new ArrayList<>(l));
            }
            return;
        }
        String substr = s.substring(i, k + 1);
        if(isStringPalindrome(substr)) {
            l.add(substr);  
            backtrack(s, k + 1, k + 1, l, output);
            l.remove(l.size() - 1);
        }
        backtrack(s, i, k + 1, l, output);
    }

    public boolean isListPalindrome(List<String> list) {
        for(String s : list) {
            if(!isStringPalindrome(s)){
                return false;
            }
        }
        return true;
    }

    public boolean isStringPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
