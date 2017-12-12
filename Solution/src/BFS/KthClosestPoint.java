package BFS;

import java.util.*;

public class KthClosestPoint {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here.
        //k also works, but probably better to use 2*k here
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>(2*k, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> l1, List<Integer> l2){
                long d1 = distance(l1, a, b, c);
                long d2 = distance(l2, a, b, c);
                if(d1 == d2){
                    return 0;
                }
                return d1 < d2? -1 : 1;
            }
        });//type is List<Integer> because we need to store three indices

        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> cur = Arrays.asList(0, 0, 0);//not the closest
        minHeap.offer(cur);
        visited.add(cur);
        //since the first one has been added(k = 1)
        //either k > 1 and peek or poll outside while loop
        //or k > 0, no need to poll outside while loop
        while(k > 1){
            cur = minHeap.poll();
            List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            //check indices in n not cur
            if(n.get(0) < a.length && visited.add(n)){//add will return false if already existed
                minHeap.offer(n);
            }
            n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if(n.get(1) < b.length && visited.add(n)){
                minHeap.offer(n);
            }
            n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if(n.get(2) < c.length && visited.add(n)){
                minHeap.offer(n);
            }
            k--;
        }

        cur = minHeap.poll();//get indices
        //replaces the indices with actual values
        cur.set(0, a[cur.get(0)]);
        cur.set(1, b[cur.get(1)]);
        cur.set(2, c[cur.get(2)]);
        return cur;
    }

    private long distance(List<Integer> point, int[] a, int[] b, int[] c){//List<Integer> point store indices
        long dis = 0;//return distance in long
        dis += a[point.get(0)]*a[point.get(0)];
        dis += b[point.get(1)]*b[point.get(1)];
        dis += c[point.get(2)]*c[point.get(2)];
        return dis;
    }
}

