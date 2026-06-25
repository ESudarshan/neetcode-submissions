class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), output);
        return output;
    }

    public void backtrack(String s, int start, List<String> l, List<List<String>> output) {
        if(start == s.length()) {
            output.add(new ArrayList<>(l));
            return;
        }

        for(int end=start; end<s.length(); end++) {
            if(isStringPalindrome(s, start, end)) {
                l.add(s.substring(start, end + 1));  
                backtrack(s, end + 1, l, output);
                l.remove(l.size() - 1);
            }
        }
    }

    public boolean isStringPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
