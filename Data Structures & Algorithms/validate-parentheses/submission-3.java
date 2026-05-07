class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        int i=0;
        int n = s.length();

        stack.push(s.charAt(0));
        i++;
        while(i<n) {
            if(!stack.isEmpty() 
                && map.containsKey(stack.peek())
                && map.get(stack.peek()).equals(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
