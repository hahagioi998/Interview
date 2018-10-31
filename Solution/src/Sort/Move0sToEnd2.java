package Sort;
//Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//要保持顺序不变，就必须从同一个方向走
//slow是所有不是0的数字，只要看快指针就好了，有点像remove adjacent
//快指针如果遇到不是0就和慢指针换（换过来的一定是0，不然都被left和right检查过了），是0就跳过
//如果没有0，那么fast和left就总是重合的，直到走到0，slow记录这个位置，fast向前
public class Move0sToEnd2 {
    public int[] moveZeroes(int[] nums) {
        //快慢指针都从0开始
        int left = 0, right = 0;
        while (right < nums.length) {
            //当快指针不是0的时候
            if (nums[right] != 0) {
                //swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                //慢指针是不是0的，可以前进
                left++;
            }
            //快指针向前
            right++;
        }
        return nums;
    }
}
