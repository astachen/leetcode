package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

// Today I've learned that always remember to have a test code about when the input does not fit in your method.
// Input is always ignored during the studies, but in the companies, this sometimes can be a serious challenge.
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    // Initialize
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue2.offer(x);
        // push all the element into the queue2 to form an inverse stack.
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // Swap queue 1 and queue 2 to form a real stack.
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue1.poll();
    }

    // Get the top element.
    public int top() {
        return queue1.peek();
    }
    // Actually if the queue1 is empty then the method pop and top will throw a NullPointerException.
    // But since the question said that the stack is not empty and the compiler cannot detect this, there are two warnings here.


    //Returns whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }


}

public class No0225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
        myStack.empty();
    }
}

