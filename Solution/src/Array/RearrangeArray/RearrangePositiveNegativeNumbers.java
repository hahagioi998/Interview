package Array.RearrangeArray;
/*
An array contains both positive and negative numbers in random order. Rearrange the array elements so that positive and negative numbers are placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

The solution is to first separate positive and negative numbers using partition process of QuickSort.
In the partition process, consider 0 as value of pivot element so that all negative numbers are placed before positive numbers.
Once negative and positive numbers are separated, we start from the first negative number and first positive number, and swap every alternate negative number with next positive number.
 */
// (The ordering of positive/negative numbers do not matter)
public class RearrangePositiveNegativeNumbers {
    public void arrange(int arr[]){
        //start of positive 就是low
        int startOfPos = segregate(arr);
        //start of negative就是1
        int startOfNeg = 1;

        //因为startOfNeg和startOfPos都在移动
        // swap every alternate negative number with next positive number.
        while(startOfNeg < startOfPos && startOfPos < arr.length){
            swap(arr, startOfNeg, startOfPos);
            startOfNeg += 2;
            startOfPos++;
        }
    }

    private int segregate(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            if(arr[low] < 0){
                low++;
            }else if(arr[high] >= 0){
                high--;
            }else{
                swap(arr,low,high);
            }
        }
        //这个返回的就是low
        return low;
    }

    private void swap(int arr[],int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String args[]){
        int arr[] = {-1,-2,-3,-4,-5,1,2,3,4,5};
        RearrangePositiveNegativeNumbers pan = new RearrangePositiveNegativeNumbers();
        pan.arrange(arr);
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
