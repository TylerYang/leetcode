class MyQueue {
    private Stack<Integer> stack;
    Integer peekEle;

    public MyQueue() {
        this.stack = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        if(stack.empty() == true) {
           this.peekEle = x;
        }
        this.stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(stack.empty() == false) {
            tmpStack.push(stack.pop());
        }
        tmpStack.pop();
        if(tmpStack.empty() == false) {
            peekEle = tmpStack.peek();
            while(tmpStack.empty() == false) {
                stack.push(tmpStack.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        return this.peekEle;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.stack.empty();
    }
}
