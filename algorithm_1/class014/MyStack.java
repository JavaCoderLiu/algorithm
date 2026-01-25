package class014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack {

    Queue<Integer> queue = null;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.add(x);
        for (int i = 0; i < n; i++) {
            int temp = queue.poll();
            queue.add(temp);
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
