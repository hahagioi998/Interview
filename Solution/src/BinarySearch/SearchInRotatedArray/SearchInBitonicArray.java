package BinarySearch.SearchInRotatedArray;
/*
Search for a target number in a bitonic array, return the index of the target number if found in the array, or return -1.

A bitonic array is a combination of two sequence: the first sequence is a monotonically increasing one and the second sequence is a monotonically decreasing one.

Assumptions:

The array is not null.
Examples:

array = {1, 4, 7, 11, 6, 2, -3, -8}, target = 2, return 5.

A simple solution is to do linear search. Time complexity of this solution would be O(n).

An efficient solution is based on Binary Search. The idea is to find the bitonic point k which is the index of the maximum element of given sequence. If the element to be searched is greater than maximum element return -1, else search the element in both halves. Below is the step by step algorithm on how to do this.

Find the bitonic point in the given array, i.e the maximum element in the given bitonic array. This can be done in log(n) time by modifying the binary search algorithm. You can refer to this post on how to do this.
If the element to be searched is equal to the element at bitonic point then print the index of bitonic point.
If the element to be searched is greater than element at bitonic point then element does not exist in the array.
If the element to be searched is less than element at bitonic point then search for element in both half of the array using binary search.
 */
public class SearchInBitonicArray {
    public int search(int[] array, int target) {
        // Write your solution here.
        int peakIndex = findPeak(array);
        if(array[peakIndex] == target){
            return peakIndex;
        }
        int temp = ascendingBinarySearch(array, 0, peakIndex - 1, target);
        if(temp != -1){
            return temp;
        }

        return descendingBinarySearch(array, peakIndex + 1, array.length - 1, target);
    }

    private int ascendingBinarySearch(int arr[], int low,
                              int high, int key)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // Binary Search function if array is
// sorted in descending order
    int descendingBinarySearch(int arr[], int low,
                               int high, int key)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int findPeak(int[] A) {
        if (A == null || A.length == 0) return -1;

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            //
            if (A[mid] < A[mid + 1]) {
                lb = mid;
            } else if (A[mid] < A[mid - 1]){
                ub = mid;
            } else {
                // find a peak
                return mid;
            }
        }

        // return a larger number
        return A[lb] > A[ub] ? lb : ub;
    }

    public static void main(String[] args){
        SearchInBitonicArray sol = new SearchInBitonicArray();
        int[] array = new int[]{-2,0,6,7,8,10,5,3};
        System.out.println(sol.search(array, 4));
    }
}
