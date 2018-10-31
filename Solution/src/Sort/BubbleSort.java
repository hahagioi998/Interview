package Sort;

//Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
//Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
/*
每次循环就会拍好循环范围内的最后一个元素
Best Case Time Complexity: O(n). Best case occurs when array is already sorted.

Auxiliary Space: O(1)

Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.

Sorting In Place: Yes

Stable: Yes
 */
public class BubbleSort {
  void bubbleSort(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n-1; i++)
      /*
        或者，要么i从0开始，不到n-1，要么从n-1开始，不到0；j要相应调整
         for (i = length - 1; 0 < i; i--) {
           for (j = 0; j < i; j++) {
       */
      //j的范围
      // 0 ... n -1
      // 0 ... n -2
      // ...
      // 0 .. 1
      for (int j = 0; j < n-i-1; j++)
        //如果当前的比后一个大
        if (arr[j] > arr[j+1])
        {
          // swap temp and arr[i]
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
  }

//  The above function always runs O(n^2) time even if the array is sorted. It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.

  static void bubbleSortII(int arr[], int n)
  {
    int i, j, temp;
    boolean swapped;
    for (i = 0; i < n - 1; i++)
    {
      swapped = false;
      for (j = 0; j < n - i - 1; j++)
      {
        if (arr[j] > arr[j + 1])
        {
          // swap arr[j] and arr[j+1]
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      //在里面for loop外面判断

      // IF no two elements were
      // swapped by inner loop, then break
      if (swapped == false)
        break;
    }
  }

  /* Prints the array */
  void printArray(int arr[])
  {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // Driver method to test above
  public static void main(String args[])
  {
    BubbleSort ob = new BubbleSort();
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    ob.bubbleSort(arr);
    System.out.println("Sorted array");
    ob.printArray(arr);
  }
}
