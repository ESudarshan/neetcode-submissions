class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(map.containsKey(s.charAt(i))) {
                if(stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
         
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
