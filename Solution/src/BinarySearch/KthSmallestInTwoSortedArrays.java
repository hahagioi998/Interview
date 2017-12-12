package BinarySearch;

public class KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        // Write your solution here.
        return kth(a, 0, b, 0, k);
    }

    private int kth(int[] a, int aleft, int[] b, int bleft, int k){

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
}
