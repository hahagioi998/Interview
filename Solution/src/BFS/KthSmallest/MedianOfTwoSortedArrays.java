package BFS.KthSmallest;

import java.util.Arrays;

//用binary search来做,找aleft和bleft，每次找中点就是left+ k/2 - 1
/*
A = {1, 4, 6}, B = {2, 3}, median is 3
A = {1, 4}, B = {2, 3}, median is 2.5
 */
public class MedianOfTwoSortedArrays {
    public double median(int[] a, int[] b) {
        int len = a.length + b.length;
        if(len % 2 == 0){
            int beforeMid = kth(a, 0, b, 0, len/2);
            int afterMid = kth(a, 0, b, 0, len/2 + 1);
            return (double)(beforeMid + afterMid)/2;
        }else{
            return kth(a, 0, b, 0, len/2+1);
        }
    }
    //只看left bound
    private int kth(int[] a, int aleft, int[] b, int bleft, int k){
        //过界了
        if(aleft >= a.length){
            return b[bleft + k - 1];
        }
        if(bleft >= b.length){
            return a[aleft + k - 1];
        }
        //如果找最小的元素
        if(k == 1){
            return Math.min(a[aleft], b[bleft]);
        }
        //get indices
        //compare the k/2th element of array a and array n
        int ak = aleft + k/2 - 1;
        int bk = bleft + k/2 - 1;

        //use max value so it won't get discarded
        //get values
        int aval = ak >= a.length ? Integer.MAX_VALUE : a[ak];
        int bval = bk >= b.length ? Integer.MAX_VALUE : b[bk];
        //compare values and discard
        if(aval < bval){
            //ak + 1 discard kth 更小的一半就不需要了， k要变成k-
            return kth(a, ak + 1, b, bleft, k - k/2);
        }else{
            return kth(a, aleft, b, bk + 1, k - k/2);
        }
    }

    public static void main(String[] args){
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[] a = new int[]{1, 4, 5};
        int[] b = new int[]{2, 3, 7};
        sol.median(a, b);
    }
}
