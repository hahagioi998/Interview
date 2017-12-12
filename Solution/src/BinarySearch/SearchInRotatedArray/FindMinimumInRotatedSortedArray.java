package BinarySearch.SearchInRotatedArray;
//假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）
//没有重复元素
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    int start = 0, end = nums.length - 1;
    //和最右边比，因为最右比最左小
    int target = nums[nums.length - 1];

    // find the first element <= target
        while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        //smaller or equal，等于不代表最小
        if (nums[mid] <= target) {
            end = mid;
        } else {
            start = mid;
        }
    }
        if (nums[start] <= target) {
        return nums[start];
    } else {
        return nums[end];
    }
}
}
