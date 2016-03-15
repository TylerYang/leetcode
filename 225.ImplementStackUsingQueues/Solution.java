import java.util.Queue;
import java.util.LinkedList;
class MyStack {
    Queue<Integer> queue;
    int topEle;
    public MyStack() {
        queue = new LinkedList();
    }
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        topEle = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> tmpQueue = new LinkedList<Integer>();
        while(queue.size() > 1) {
            int tmp = queue.poll();
            if(queue.size() == 1) {
                topEle = tmp;
            }
            tmpQueue.add(tmp);
        }
        this.queue = tmpQueue;
    }

    // Get the top element.
    public int top() {
        return topEle;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}
