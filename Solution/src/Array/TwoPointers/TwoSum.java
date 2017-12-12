package Array.TwoPointers;

import java.util.Arrays;
//在while里面有等于，小于和大于三种情况
public class TwoSum {
    public boolean existSum(int[] array, int target) {
        // 一定要sort array
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int sum = array[left] + array[right];
            if(sum == target){
                return true;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
