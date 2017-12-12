package BinarySearch;

import java.util.Arrays;

//直接把两个array合并（反正都是unsorted），再用quick select来做，时间复杂度就是O(n)
public class MedianOfTwoUnsortedArray {
    public double median(int[] a, int[] b) {
        // not sorted arrays
        // need do quick select
        // combine two arrays first
        int[] array = new int[a.length + b.length];
        // laicode doesn't support the following arraycopy: Invalid dependency java/lang/System
        // work OK in eclipse
        //System.arraycopy(a, 0, array, 0, a.length);
        //System.arraycopy(b, 0, array, a.length, b.length);
        int c = 0;
        for (int num : a) {
            array[c++] = num;
        }

        for (int num : b) {
            array[c++] = num;
        }

        if (array.length % 2 != 0) {
            return helper(array, 0, array.length - 1, array.length / 2);
        } else {
            return (helper(array, 0, array.length - 1, array.length / 2 - 1) + helper(array, 0, array.length - 1, array.length / 2)) / 2;
        }
    }

    private double helper(int[] array, int left, int right, int k) {
        int pivotIndex = findPivot(array, left, right);
        if (pivotIndex == k) {
            return (double) array[pivotIndex];
        }

        if (pivotIndex < k) {
            return helper(array, pivotIndex + 1, right, k);
        } else {
            return helper(array, left, pivotIndex - 1, k);
        }
    }

    private int findPivot(int[] array, int left, int right) {
        if (left >= right) {
            return left;
        }
        // pick the middle one as the pivot;
        int mid = left + (right - left) / 2;
        swap(array, mid, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if(array[i] <= array[right]) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
