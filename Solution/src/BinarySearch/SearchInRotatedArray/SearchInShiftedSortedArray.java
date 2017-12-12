package BinarySearch.SearchInRotatedArray;
//There are no duplicate elements in the array.
//A = {3, 4, 5, 1, 2}, T = 4, return 1
//        A = {1, 2, 3, 4, 5}, T = 4, return 3
//        A = {3, 5, 6, 1, 2}, T = 4, return -1
//What if A is null or A is of zero length? We should return -1 in this case.
public class SearchInShiftedSortedArray {
    public int search(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            //这个区域的两边一定是左边比右边高，左边上升到最大值，然后从最小值开始上升
            //a[left] > a[right]
            //要先把mid和最左边比较，注意是>=
            //要看mid在哪个区域，然后在看target在mid左边还是右边
            if (array[mid] >= array[left]) {
                //一定是在更高层的升序,此时就看target的位置
                if (target >= array[left] && target < array[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {//比left小，在低一层，和array[right]比
                if (target <= array[right] && target > array[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }
}
