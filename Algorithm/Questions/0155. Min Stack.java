class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.add(val);
        } else {
            minStack.add(minStack.peek());
        }
        stack.add(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return  minStack.peek();
    }
}