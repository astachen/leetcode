package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

// This question is pretty similar comparing to the No0225.
// This time I wrote a special method to achieve the goal.
class MyQueue {
    // Initialize
    static Deque<Integer> Stack1;
    static Deque<Integer> Stack2;

    public MyQueue() {
        Stack1 = new ArrayDeque<Integer>();
        Stack2 = new ArrayDeque<Integer>();
    }

    // Push element x onto queue
    public static void push(int x) {
        Stack1.push(x);
    }

    // Removes the element on top of the queue and returns that element.
    public static int pop() {
        if (Stack2.isEmpty()) {
            reverseStack();
        }
        return Stack2.pop();
    }

    // Get the top element.
    public static int peek() {
        if (Stack2.isEmpty()) {
            reverseStack();
        }
        return Stack2.peek();
    }

    //Returns whether the stack is empty.
    public static boolean empty() {
        return Stack1.isEmpty() && Stack2.isEmpty();
    }

    // push all the element into the stack 2 to form an inverse stack, which will become a queue.
    private static void reverseStack() {
        while (!Stack1.isEmpty()) {
            Stack2.push(Stack1.pop());
        }
    }
}


public class No0232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        MyQueue.push(1);
        MyQueue.push(2);
        MyQueue.peek();
        MyQueue.pop();
        MyQueue.empty();
    }

}
