class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        int balance = 0;
        StringBuilder p = new StringBuilder(); 
        dfs(p, 2*n , output);
        return output;
    }

    public void dfs(StringBuilder p, int n, List<String> output) {
        if(p.length() == n) {
            if(isValid(p)) {
                output.add(p.toString());
            }
             return;
        }

        dfs(p.append('('), n , output);
        p.deleteCharAt(p.length() - 1);
        dfs(p.append(')'), n, output);
        p.deleteCharAt(p.length() - 1);
    }

    boolean isValid(StringBuilder p) {
        int balance = 0;
        for(char ch : p.toString().toCharArray()) {
            if(ch == '(') {
                balance++;
            } else if(ch == ')') {
                balance--;
            }
            if(balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
