package Array;

import java.util.Arrays;

public class FindMissingNumber {
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) { //sum
        int len = nums.length;
        int sum = (0 + len)*(len + 1)/2;
        for(int i = 0; i < len; i++)
            sum -= nums[i];
        return sum;
    }

    public int missingNumber3(int[] nums) { //binary search
        //这里要sort
        Arrays.sort(nums);
        //这里right是nums.length
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] > mid) {
                right = mid;
            }
            else {
                //<说明在后半段
                //=说明是对的
                left = mid+1;
            }
        }
        return left;
    }
}
