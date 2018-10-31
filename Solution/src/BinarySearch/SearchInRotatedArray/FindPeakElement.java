package BinarySearch.SearchInRotatedArray;
/*
 * A peak element is an element that is greater than its neighbors. Find index of peak element in the array.
 *
 * Space complexity is O(1)
 * Time complexity is O(n)
 */

/*
由时间复杂度的暗示可知应使用二分搜索。首先分析若使用传统的二分搜索，若A[mid] > A[mid - 1] && A[mid] < A[mid + 1]，则找到一个peak为A[mid]；
若A[mid - 1] > A[mid]，则A[mid]左侧必定存在一个peak，可用反证法证明：若左侧不存在peak，则A[mid]左侧元素必满足A[0] > A[1] > ... > A[mid -1] > A[mid]，与已知A[0] < A[1]矛盾，证毕。同理可得若A[mid + 1] > A[mid]，则A[mid]右侧必定存在一个peak。如此迭代即可得解。由于题中假设端点外侧的值均为负无穷大，即num[-1] < num[0] && num[n-1] > num[n], 那么问题来了，这样一来就不能确定峰值一定存在了，因为给定数组为单调序列的话就咩有峰值了，但是实际情况是——题中有负无穷的假设，也就是说在单调序列的情况下，峰值为数组首部或者尾部元素，谁大就是谁了。
备注：如果本题是找 first/last peak，就不能用二分法了。
 */

public class FindPeakElement {
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) return -1;

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            //抛左边
            if (A[mid] < A[mid + 1]) {
                lb = mid;
            } else if (A[mid] < A[mid - 1]){
                //和抛右边
                ub = mid;
            } else {
                // find a peak
                return mid;
            }
        }

        // return a larger number
        return A[lb] > A[ub] ? lb : ub;
    }

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        while (low <= high) {
            middle = (low + high)/2;
            int before = Integer.MIN_VALUE;

            if (middle > 0) {
                before = nums[middle - 1];
            }
            int after = Integer.MIN_VALUE;
            if (middle < nums.length - 1) {
                after = nums[middle + 1];
            }
            if (nums[middle] > before && nums[middle] > after) {
                return middle;
            } else if (before > after) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return middle;
    }

    public static void main(String args[]){
        int arr[] = {10,5,15,2,23,90,67};
        FindPeakElement pe = new FindPeakElement();
        System.out.println(pe.findPeak(arr));
        int arr1[] = {10,20,30,40,50};
        System.out.println(pe.findPeak(arr1));
        int arr2[] = {100,90,80,70,60};
        System.out.println(pe.findPeak(arr2));

    }
}
