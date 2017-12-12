package Array;
/*
Input :  A[] = {2, 2, 4, 5, 8, 9}
         B[] = {2, 5, 9}
Output : 5
Smallest subarray of A[] that contains all
elements of B[] is {2, 4, 5, 8, 9} which is
of size 5.

Input :  A[] = {5, 6, 5, 2, 7, 5, 6, 7, 5, 5, 7}
         B[] = {5, 5, 7}
Output : 3
 */
/*
Method 1 (Naive)

A simple solution is to generate all subarrays of given array and check for every sub-array if it contains elements of another array or not. In the end, return the minimum length of sub-array that contain another array.
O(n^2)
 */
/*
Method 2 is an optimized version of method 1. Here we consider only those subarrays whose first element match with the first element of second array. If first element matches, then we match the rest of the elements of second array in the Main_array and if all elements match then we update length if need. In the end, we return minimum length of sub_array.
 */
public class SmallestSubarrayThatContainsAllElementsSameOrder
{
    static int minimumSubArray(int A[], int n, int B[],
                        int m) {
        int result = Integer.MAX_VALUE;

        // Traverse main_array element
        // 在array里面找array n - m + 1
        for (int i = 0; i < n - m + 1; i++) {
            // Pick only those subarray of main_array
            // whose first element match with the
            // first element of second_array
            if (A[i] == B[0]) {

                // initialize starting of both
                // subarrays
                //index就是A里新的起点，是fast pointer，i是起点
                int j = 0, index = i;
                //index用一个for loop来加
                for (; index < n; index++) {
                    if (A[index] == B[j])
                        //当相等的时候B的index才加
                        j++;

                    // if we found all elements of
                    // second array
                    if (j == m)
                        break;
                }

                // update minimum length sub_array
                //用index来找个数的话要+1
                //result >= index - i + 1 吧
                if (j == m && result > index - i + 1)
                    //如果for loop break的时候index是length的话，就不用+1了
                    result = (index == n) ? index - i : index - i + 1;
            }
        }

            // return minimum length subarray
            return result;
    }

    public static void main(String[] args)
    {
        int A[] = { 5, 6, 5, 2, 7, 5, 6, 7, 5, 5, 7 };
        int B[] = { 5, 5, 7 };
        int n = A.length;
        int m = B.length;
        System.out.println(minimumSubArray(A, n, B, m));
    }

}
