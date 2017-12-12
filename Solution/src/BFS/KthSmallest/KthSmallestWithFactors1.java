package BFS.KthSmallest;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Kth Smallest With Only 2, 3 As Factors
//Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.
//单调非递增 BFS2 priorityqueue
public class KthSmallestWithFactors1 {
    public int kth(int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        minHeap.offer(1);
        Set<Integer> visited = new HashSet<>();

        //it's possible to get dup number, 3^2*5^2*7, 3 could get multiplied first, then 5 or vice versa
        //minimum is 1 because x and y could be 0
        visited.add(1);//K = 1

        while(k > 1){//k = 1 has been added
            int cur = minHeap.poll();//multiple with the minimum

            //y = 0, no 3
            if(cur % 2 == 0){
                if(visited.add(cur/2)){//check if it's visited and add to set
                    minHeap.offer(cur/2);
                }
            }

            //no 2, x = 0
            if(cur % 3 == 0){
                if(visited.add(cur/3)){//check if it's visited and add to set
                    minHeap.offer(cur/3);
                }
            }

            if(visited.add(cur*3)){//check if it's visited and add to set
                minHeap.offer(cur*3);
            }

            if(visited.add(cur*2)){//check if it's visited and add to set
                minHeap.offer(cur*2);
            }
            k--;
        }
        return minHeap.peek();
    }
}
