package BFS.KthSmallest;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integer

public class KthSmallestWithFactors2 {
    public long kth(int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        minHeap.offer(3*5*7L);

        Set<Long> visited = new HashSet<>();
        //it's possible to get dup number, 3^2*5^2*7, 3 could get multiplied first, then 5 or vice versa
        visited.add(3*5*7L);//K = 1

        while(k > 1){//k = 1 has been added
            long cur = minHeap.poll();//multiple with the minimum

            if(visited.add(cur*3)){//check if it's visited and if not add to set
                minHeap.offer(cur*3); //if not visited then offer
            }

            if(visited.add(cur*5)){//check if it's visited and add to set
                minHeap.offer(cur*5);
            }

            if(visited.add(cur*7)){//check if it's visited and add to set
                minHeap.offer(cur*7);
            }
            k--;
        }
        return minHeap.peek();
    }
}
