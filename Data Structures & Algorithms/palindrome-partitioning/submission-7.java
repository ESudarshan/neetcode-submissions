class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), output);
        return output;
    }

    public void backtrack(String s, int i, int k, List<String> l, List<List<String>> output) {
        if(k == s.length()) {
            if(i == k) {
                output.add(new ArrayList<>(l));
                 return;
            }
            return;
        }

        if(isStringPalindrome(s, i, k)) {
            l.add(s.substring(i, k + 1));  
            backtrack(s, k + 1, k + 1, l, output);
            l.remove(l.size() - 1);
        }

        backtrack(s, i, k + 1, l, output);
    }

    public boolean isStringPalindrome(String s, int l, int r) {
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
