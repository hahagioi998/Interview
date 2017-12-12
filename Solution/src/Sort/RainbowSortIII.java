package Sort;
//Given an array of balls with k different colors denoted by numbers 1- k, sort the balls.
//k=5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}
//        Assumptions
//
//        The input array is not null.
//        k is guaranteed to be >= 1.
//        k << logn.
// version 1: O(nlogk), the best algorithm based on comparing
public class RainbowSortIII {
    public int[] rainbowSortIII(int[] array, int k) {
    rainbowSort(array, 0, array.length - 1, 1, k);
    return array;
}

    public void rainbowSort(int[] array, int left, int right, int colorFrom, int colorTo) {
        // if only 1 color left, return
        if (colorFrom == colorTo) {
            return;
        }
        // if left >= right, return
        if (left >= right) {
            return;
        }


        int colorMid = (colorFrom + colorTo) / 2;
        int i = left;
        int j = right;
        //二分法
        while (i <= j) {
            //不过同样的颜色要一直跳过
            // if array[i] <= colorMid, i++
            while (i <= j && array[i] <= colorMid) {
                i++;
            }
            // if array[j] > colorMid, j--
            while (i <= j && array[j] > colorMid) {
                j--;
            }

            if (i <= j) {
                swap(array, i++, j--);
            }
        }
        rainbowSort(array, left, j, colorFrom, colorMid);
        rainbowSort(array, i, right, colorMid + 1, colorTo);
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
