package Array.RearrangeArray;

import java.util.Arrays;

/*
Given an array with both positive and negative numbers in random order. Shuffle the array so that positive and negative numbers are put in position with even and odd indices, respectively.

If there are more positive/negative numbers, put them at the end of the array. The ordering of positive/negative numbers does not matter.

Assumptions:

The given array is not null.
There is no 0 in the array.
Examples:

{1, 2, 3, 4, 5, -1, -1, -1} --> {1, -1, 2, -1, 3, -1, 4, 5}  maintain the order!
http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 */
public class InterleavePositiveAndNegativeElements {
    int[] subfun(int[] A,int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
        }
        if(len % 2 == 1)
            ans[len - 1] = A[len / 2];
        return ans;
    }
    public void rerange(int[] A) {
        int[] Ap = new int[A.length];
        int totp = 0;
        int totm = 0;
        int[] Am = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++)
            if(A[i] > 0)
            {
                Ap[totp] = A[i];
                totp += 1;
            }
            else
            {
                Am[totm] = A[i];
                totm += 1;
            }
        if(totp > totm)
            tmp = subfun(Ap, Am, A.length);
        else
            tmp = subfun(Am, Ap, A.length);
        for (int i = 0; i < tmp.length; ++i)
            A[i] = tmp[i];
    }

    public static void main(String[] args){
        InterleavePositiveAndNegativeElements sol = new InterleavePositiveAndNegativeElements();
        int[] A = new int[]{-1, -2, 8, -3, -5, 10, 4, 5, 6, 2, 9};
        sol.rerange(A);
        System.out.println(Arrays.toString(A));
    }
}
