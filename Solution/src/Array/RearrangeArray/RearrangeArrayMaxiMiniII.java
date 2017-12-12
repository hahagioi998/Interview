package Array.RearrangeArray;

import java.util.Arrays;
//do it in place
//The idea is to use multiplication and modular trick to store two elements at an index.
/*
How does expression “arr[i] += arr[max_index] % max_element * max_element” work ?
The purpose of this expression is to store two elements at index arr[i].
arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder.
For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0.
With 91, we can get original element as 91%10 and new element as 91/10.
 */
//rearrange an array in maximum minimum form
//Input  : arr[] = {1, 2, 3, 4, 5, 6, 7}
//Output : arr[] = {7, 1, 6, 2, 5, 3, 4}
public class RearrangeArrayMaxiMiniII {
    public static int[] rearrange(int[] arr){
        // initialize index of first minimum and first
        // maximum element
        int n = arr.length;
        int max_idx = n-1 , min_idx = 0 ;

        // store maximum element of array
        int max_elem = arr[n-1] + 1 ;

        // traverse array elements
        for (int i=0; i < n ; i++)
        {
            // at even index : we have to put maximum element
            if (i % 2 == 0)
            {
                arr[i] += (arr[max_idx] % max_elem ) * max_elem;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else
            {
                arr[i] += (arr[min_idx] % max_elem ) * max_elem;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0 ; i < n; i++)
            arr[i] = arr[i] / max_elem ;

        return arr;
    }

    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        int[] res = rearrange(arr);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(res));

    }
}
