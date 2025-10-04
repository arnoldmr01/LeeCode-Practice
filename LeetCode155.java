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
