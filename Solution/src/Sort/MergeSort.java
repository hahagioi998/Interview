package Sort;

public class MergeSort {
    // time complexity for division O(1) + O(2) + O(4) + ... + O(n/2) < O(n)
    // time complexity for merge O(nlogn)
    //overall time complexity O(nlogn)
    //space complexity O(n), helper array is O(n) size + callstack->O(n/2) +O(n/4)+O(n/8)+...O(1)= 2n= O(n) space
    public int[] mergeSort(int[] array) {
      if(array == null || array.length <= 1){
        return array;
      }
      int[] helper = new int[array.length];//avoid creating new helper array for each merge
      mergeSort(array, helper, 0, array.length - 1);
      return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        //条件实际上是因为在用二分法
        if(left >= right) {//end of recursion,when there are two numbers left, left = right because right - left = 1, mid + 1 = right
            return;
        }

        // 0 1 2 3 4 5 mid = index 2 也就是 2
      // 0 1 2 3 4 mid = index 2 也就是 2
        int mid = left + (right - left)/2;
        mergeSort(array, helper, left, mid); //(left) right = mid, divide until it reaches a single number
        mergeSort(array, helper, mid + 1, right); // use mid + 1 instead of mid
        merge(array, helper, left, mid, right);
    }

    //need helper array because it's not simple swap, left and right bounds the elemets
    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        //only copy the specific part, has to include left and right bounds!!
      //先拷到helper，用helper比较，然后放到原array里
        for(int i = left ; i <= right; i++) {
            helper[i] = array[i];
        }

        //merge的时候拿到了两段，从各自的最左端leftIndex和rightIndex开始比较
        //把原array里的数字由left指向复制到对的位置
        int leftIndex = left; //left pointer on helper array
        int rightIndex = mid + 1;//right pointer on helper array
        while(leftIndex <= mid && rightIndex <= right) {
          //leftIndex和rightIndex谁小移谁
            if(helper[leftIndex] <= helper[rightIndex]) {//two pointers
                //这里是说明array left不应该变还是left
                array[left++] = helper[leftIndex++];
            }else {
                //这里是把right copy到array里去，这里是rightIndex++了
                array[left++] = helper[rightIndex++];
            }
        }

        // possible still have elements on the left, while right reach the bound first
        // as the element on the right are smaller
        while(leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }
}
