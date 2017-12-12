package Deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.
//A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
public class MaxWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        // i is the fast pointer
        // k is the size of sliding window
        List<Integer> max = new ArrayList<>();

        //we need a structure to keep track of max index(element) is sliding windown
        // a sliding window problem, need to remove from front, and add from back
        // if we want to know which one is the max, we need to compare with previous element and only keep max
        // so we need a Deque
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0 ; i < array.length; i++){
            //if the last element(last index) is smaller than current element(index i)
            while(!deque.isEmpty() && array[deque.peekLast()] <= array[i]){
                deque.pollLast(); //
            }

            // if the front index is <= i - k, then we need to remove from front
            if(!deque.isEmpty() && deque.peekFirst() <= i - k ){
                deque.pollFirst();
            }

            //offerLast index
            deque.offerLast(i);

            //
            if(i >= k - 1){
                max.add(array[deque.peekFirst()]);
            }

        }

        return max;
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 3, 2, 4, 2, 1 };
        boolean[] B = new boolean[A.length];
        MaxWindows i = new MaxWindows();
        System.out.println(i.maxWindows(A, 3));

    }
}
