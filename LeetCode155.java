class MinStack {
    Stack<Integer> valueStack;
    Stack<Integer> minStack;

    public MinStack() {
        this.valueStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        valueStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        int val = valueStack.pop();
        if (val == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return valueStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */