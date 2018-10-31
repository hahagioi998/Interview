package BFS.KthSmallest;

import java.util.Arrays;
import java.util.Random;

//Use QuickSelect
//Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
//虽然不知道正确的数字，但是可以知道正确的index
public class KthLargestInUnsortedArray {
    public int findKthLargest(int[] array, int k) {
        shuffle(array);
        if(array.length == 0 || k == 0){
            return -1;
        }

        if(array.length == 1){
            return array[0];
        }

        kSmallest(array, 0, array.length - 1, k - 1); //every element until index k - 1 will be smaller, but not sorted
        int[] res = Arrays.copyOf(array, k);//copy out the first k element, use Arrays not Array
        //如果是largest,这个sort又会变成ascending的了，所以最后要用res.length - k
        Arrays.sort(res);
        return res[res.length - k];
    }

    private void kSmallest(int[] array, int left, int right, int target){
        //通过quickselect来找到piv，piv是index
        int piv = quickSelect(array, left, right);

        //知道找到的piv是正确的index
        if(piv == target){
            return;//no need to return piv
        }else if(piv < target){//
            kSmallest(array, piv + 1, right, target);//recursively call itself
        }else{
            kSmallest(array, left, piv - 1, target);
        }

    }

    private int quickSelect(int[] array, int left, int right){
        //这里就取array的右端作为pivot
        int piv = array[right];
        //用新的variable
        int start = left;
        //最右端的被取了
        int end = right - 1;
        //简单的swap，最会汇合在中间
        while(start <= end){
            if(array[start] > piv){
                start++;
            }else if(array[end] <= piv){
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

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    public static void main(String[] args) {
        KthLargestInUnsortedArray kthLargestInUnsortedArray = new KthLargestInUnsortedArray();
        int[] array = new int[]{3,2,1,5,6,4};
        int res = kthLargestInUnsortedArray.findKthLargest(array, 2);
        System.out.println(res);
    }

}
