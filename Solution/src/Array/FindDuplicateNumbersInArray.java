package Array;
/*
You are given an array of n+2 elements. All elements of the array are in range 1 to n.
And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

Method 5 (Use array elements as index)
Thanks to Manish K. Aasawat for suggesting this method.

Traverse the array. Do following for every index i of A[].
{
check for sign of A[abs(A[i])] ;
if positive then
   make it negative by   A[abs(A[i])]=-A[abs(A[i])];
else  // i.e., A[abs(A[i])] is negative
   this   element (ith element of list) is a repetition
}
Example: A[] =  {1, 1, 2, 3, 2}
i=0;
Check sign of A[abs(A[0])] which is A[1].  A[1] is positive, so make it negative.
Array now becomes {1, -1, 2, 3, 2}

i=1;
Check sign of A[abs(A[1])] which is A[1].  A[1] is negative, so A[1] is a repetition.

i=2;
Check sign of A[abs(A[2])] which is A[2].  A[2] is  positive, so make it negative. '
Array now becomes {1, -1, -2, 3, 2}

i=3;
Check sign of A[abs(A[3])] which is A[3].  A[3] is  positive, so make it negative.
Array now becomes {1, -1, -2, -3, 2}

i=4;
Check sign of A[abs(A[4])] which is A[2].  A[2] is negative, so A[4] is a repetition.
Note that this method modifies the original array and may not be a recommended method if we are not allowed to modify the array.
 */
public class FindDuplicateNumbersInArray {
    void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for(i = 0; i < size; i++)
        {
            //因为重复的数字会给你同样的index->同样的值->发现被修改过了
            //适用于全部是正数的array
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    /*
    There is a problem in above approach. It prints the repeated number more than once.
    For example: {1, 6, 3, 1, 3, 6, 6} it will give output as : 3 6 6.
    So, in this article, another method is discussed to overcome this problem.
    1- Traverse the given array from i= 0 to n-1 elements
     Go to index arr[i]%n and increment its value by n.
    3- Now traverse the array again and print all those
   indexes i for which arr[i]/n is greater than 1.

    This approach works because all elements are in range
    from 0 to n-1 and arr[i]/n would be greater than 1
    only if a value "i" has appeared more than once.
     */

    void printRepeating2( int arr[], int n)
    {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++)
        {

            if ((arr[i]/n) > 1)
                //这里的i 其实就是index 就是array[i]
                System.out.println(i);
        }
    }



    /* Driver program to test the above function */
    public static void main(String[] args)
    {
        FindDuplicateNumbersInArray repeat = new FindDuplicateNumbersInArray();
        int arr[] = {1, 6, 3, 1, 3, 6, 6};
        int arr_size = arr.length;
        repeat.printRepeating2(arr, arr_size);
    }
}
