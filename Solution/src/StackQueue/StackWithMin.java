package StackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    public StackWithMin() {
        // write your solution here
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<Integer>();
    }

    public int pop() {
        if(stack1.isEmpty()){
            return -1;
        }
        stack2.pollFirst();
        return stack1.pollFirst();
    }

    public void push(int element) {
        stack1.offerFirst(element);
        if(stack2.isEmpty() || element <= stack2.peekFirst()){//stack2 could be empty, need to check if empty before peek
            stack2.offerFirst(element);
        }else{
            stack2.offerFirst(stack2.peekFirst());
        }
    }

    public int top() {
        if(stack2.isEmpty()){
            return -1;//return -1
        }
        return stack1.peekFirst();
    }

    public int min() {
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.peekFirst();
    }
}
