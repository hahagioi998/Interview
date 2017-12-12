package Array;
//If nums = [3,2,2,1] and k=2, a valid answer is 1.
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        //write your code here
        //二分排序，相向
        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }//left推进到不再小于k

            while (left <= right && nums[right] >= k) {
                right--;
            }//right向左推进到不再大于等于k

            if (left <= right) {//互换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;//跳过
                right--;
            }
        }
        return left;//left就是最后的小于k的位置

    }
}
