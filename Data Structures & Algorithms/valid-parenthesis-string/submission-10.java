class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                left.push(i);
            }
            if(s.charAt(i) == '*') {
                star.push(i);
            }
            if(s.charAt(i) == ')') {
                if(!left.isEmpty()) {
                    left.pop();
                } else if(!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while(!left.isEmpty() && !star.isEmpty()) {
            if(left.peek() > star.peek()) {
               return false;
            } 
            left.pop();
            star.pop();
        }
        return left.isEmpty();
    }
}
