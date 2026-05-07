class MinStack {
    
    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
         stack = new LinkedList<>();
         minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(minStack.isEmpty() || val <= minStack.getLast()) {
            minStack.addLast(val);
        }
    }
    
    public void pop() {
        // System.out.println(stack);
        // System.out.println(minStack);
        if(minStack.getLast().equals(stack.getLast())) {
            minStack.removeLast();
        } else {
            System.out.println(minStack.getLast());
            System.out.println(stack.getLast());
            System.out.println(minStack);
        }
        stack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
