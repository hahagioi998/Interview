package BinarySearch;
//Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.
public class TotalOccurrence {
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //target超过了
        if(target > A[A.length - 1]){
            return 0;
        }

        int start, end, mid;
        int left = 0, right = 0;
        // search for left bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            left = start;
        } else{
            left = end;
        }

        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            right = end;
        } else{
            right = start;
        }
        //left等于right的时候，说明就只有1个
        return right == left? 1 : right - left + 1;
    }
}
