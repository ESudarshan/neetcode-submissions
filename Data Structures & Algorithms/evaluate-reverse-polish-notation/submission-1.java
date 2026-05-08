class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n=tokens.length;
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(int i=0; i<n; i++) {
            if(operators.contains(tokens[i])) {
                int r = stack.pop();
                int l = stack.pop();
                int res = calculate(tokens[i], l, r);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    int calculate(String opr, int l, int r) {
        switch(opr) {
            case "+":
                    return l+r;
            case "-":
                    return l-r;
            case "*":
                    return l*r;
            case "/":
                    return l/r;
        }
        return 0;
    }
}
