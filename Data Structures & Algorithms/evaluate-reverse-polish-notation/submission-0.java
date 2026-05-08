class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int n=tokens.length;
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(int i=0; i<n; i++) {
            if(operators.contains(tokens[i])) {
                int r = Integer.parseInt(stack.pop());
                int l = Integer.parseInt(stack.pop());
                int res = calculate(tokens[i], l, r);
                stack.push(String.valueOf(res));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
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
