package Array;
/*
Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.
 */
public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        // Write your solution here.
        // The first element is the largest number,
        // the second element is the smallest number.
        int n = array.length;
        // indices x 和 n - 1 - x pair up，两个里面的大的会被放到左半边
        //最开头和最末尾两两一对
        for(int i = 0; i < n/2; i++){
            if(array[i] < array[n - 1 -i]){
                swap(array, i, n - 1 -i);
            }
        }
        //最大值是左半边的最大值，最小值是右半边的最小值
        //边界要注意奇数的话((n - 1)/2)和n/2-1不一样
        return new int[]{largest(array, 0, (n - 1)/2), smallest(array, n/2, n - 1)};
    }

    private int largest(int[] array, int left, int right){
        int largest = array[left];
        for(int i = left + 1; i <= right; i++){
            largest = Math.max(largest, array[i]);
        }
        return largest;
    }

    private int smallest(int[] array, int left, int right){
        int smallest = array[left];
        for(int i = left + 1; i <= right; i++){
            smallest = Math.min(smallest, array[i]);
        }
        return smallest;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
