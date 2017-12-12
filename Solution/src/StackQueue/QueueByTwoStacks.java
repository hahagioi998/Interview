package StackQueue;

import java.util.LinkedList;

//The elements in the queue are all Integers.
//        size() should return the number of elements buffered in the queue.
//        isEmpty() should return true if there is no element buffered in the queue, false otherwise.

public class QueueByTwoStacks {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;
    public QueueByTwoStacks() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    //只要在poll的时候移动就可以了
    public Integer poll() {
        move(); //move will check if stack2 is empt
        //还要考虑poll不到的问题
        return stack2.isEmpty()? null : stack2.pollFirst();
    }

    //放进stack1
    public void offer(int element) {
        stack1.offerFirst(element);
    }

    //peek的时候也要move
    public Integer peek() {//return null if empty
        move();
        return stack2.isEmpty()? null : stack2.peekFirst();
    }

    //size一定是两个stack的size之和
    public int size() {
        return stack1.size() + stack2.size();
    }

    //如果
    public boolean isEmpty() {
        if(stack2.isEmpty()){
            return stack1.isEmpty();
        }
        return false;
    }

    private void move(){//extract
        //只有在stack2是空的时候才move，而且把stack1全移动过来
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
        }
    }
}
