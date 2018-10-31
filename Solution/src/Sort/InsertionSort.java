package Sort;
/*
Uses: Insertion sort is used when number of elements is small.
It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
 */
public class InsertionSort {
  void sort(int arr[])
  {
    int n = arr.length;
    for (int i = 1; i < n; ++i)
    {
      //从第二个元素开始
      int key = arr[i];
      //j从i前一个元素开始
      int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            //一个一个和前面的元素比，插到合适的地方
      while (j >= 0 && arr[j] > key)
      {
        //j可以到最前面，只要有一个元素比key大，就一个一个向后copy
        arr[j + 1] = arr[j];
        //j向前
        j = j - 1;
      }
      //这里j要么等于-1，要么等于i - 1也就是不动，要么就是插入点的前一个
      arr[j + 1] = key;
    }
  }

  /* A utility function to print array of size n*/
  static void printArray(int arr[])
  {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i] + " ");

    System.out.println();
  }

  // Driver method
  public static void main(String args[])
  {
    int arr[] = {12, 11, 13, 5, 6};

    InsertionSort ob = new InsertionSort();
    ob.sort(arr);

    printArray(arr);
  }
}
