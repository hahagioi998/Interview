package BFS.KthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

//Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b,
// where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.
public class KthSmallestSumSortedArray {
    public int kthSum(int[] A, int[] B, int k) {
        //need to define max or min heap, this is a min heap
        PriorityQueue<Cell> heap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.sum == o2.sum) {
                    return 0;
                }
                return o1.sum < o2.sum? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[A.length][B.length];
        visited[0][0] = true;

        int indexA = 0, indexB = 0;
        heap.offer(new Cell(indexA, indexB, A[indexA] + B[indexB]));
        for(int i = 0; i < k - 1; i++){
            Cell cur = heap.poll();
            indexA = cur.indexA;
            indexB = cur.indexB;

            if(indexA + 1 < A.length && !visited[indexA + 1][indexB]){
                visited[indexA + 1][indexB] = true;
                heap.offer(new Cell(indexA + 1, indexB, A[indexA + 1] + B[indexB]));
            }

            if(indexB + 1 < B.length && !visited[indexA][indexB + 1]){
                visited[indexA][indexB + 1] = true;
                heap.offer(new Cell(indexA, indexB + 1, A[indexA] + B[indexB + 1]));
            }

        }

        return heap.peek().sum;
    }

    class Cell{
        int indexA;
        int indexB;
        int sum;
        Cell(int a, int b, int sum){//need to use this in a inner class
            this.indexA = a;
            this.indexB = b;
            this.sum = sum;
        }
    }
}
