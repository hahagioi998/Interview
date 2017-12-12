package BFS.KthSmallest;

import java.util.Arrays;

//Use QuickSelect
//Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(array.length == 0 || k == 0){
            return new int[0];
        }

        kSmallest(array, 0, array.length - 1, k - 1); //every element until index k - 1 will be smaller, but not sorted
        int[] res = Arrays.copyOf(array, k);//copy out the first k element, use Arrays not Array
        //这里还是要sort一下
        Arrays.sort(res);
        return res;
    }

    private void kSmallest(int[] array, int left, int right, int target){
        //通过quickselect来找到piv
        int piv = quickSelect(array, left, right);

        //这里因为是一半的quick sort，就又要做一次二分判断
        if(piv == target){
            return;//no need to return piv
        }else if(piv < target){//
            kSmallest(array, piv + 1, right, target);//recursively call itself
        }else{
            kSmallest(array, left, piv - 1, target);
        }

    }

    private int quickSelect(int[] array, int left, int right){
        //这里就去array的右端作为pivot
        int piv = array[right];
        int start = left;
        //在right的基础上再-1
        int end = right - 1;
        //二分法
        while(start <= end){
            if(array[start] < piv){
                start++;
            }else if(array[end] >= piv){
                end--;
            }else{
                swap(array, start++, end--);
            }
        }

        swap(array, start, right);
        //返回左边
        return start;
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
      public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if (array.length == 0 || k == 0) {
      return new int[0];
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1.equals(o2)) {
          return 0;
        }
        return o1 > o2 ? -1 : 1;
      }
    } );

    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()) {//take larger ones out
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    int result[] = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = maxHeap.poll();
    }
    return result;
  }
     */
}
