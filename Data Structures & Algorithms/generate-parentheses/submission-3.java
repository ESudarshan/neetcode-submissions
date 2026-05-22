class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, 0, 0, output);
        return output;
    }

    public void dfs(StringBuilder sb, int n, int open, int close, List<String> output) {
        if(sb.length() == 2 * n) {
            if(open == close) {
                output.add(sb.toString());
                 return;
            }
           
        }

        if(open <  n) {
            open++;
            dfs(sb.append('('), n, open, close, output);
            sb.deleteCharAt(sb.length() - 1);
            open--;
        }

        if(close <  open) {
            close++;
            dfs(sb.append(')'), n, open, close, output);
            sb.deleteCharAt(sb.length() - 1);
            close--;
        }

    }

}
