class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), output);
        return output;
    }

    public void backtrack(String s, int start, int end, List<String> l, List<List<String>> output) {
        if(end == s.length()) {
            if(start == end) {
                output.add(new ArrayList<>(l));
                 return;
            }
            return;
        }

        if(isStringPalindrome(s, start, end)) {
            l.add(s.substring(start, end + 1));  
            backtrack(s, end + 1, end + 1, l, output);
            l.remove(l.size() - 1);
        }

        backtrack(s, start, end + 1, l, output);
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
