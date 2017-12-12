package Array.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.
//A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
public class TwoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // 先sort
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();

        int left = 0;
        int right = array.length - 1;
        while(left < right){
            //跳过所有相同的
            if(left > 0){
                while(array[left] == array[left - 1]){//only need to change left
                    left++;
                }
                //这样一开始left是第一个重复的，然后break的时候left就不是重复的了
            }
            int sum = array[left] + array[right];
            if(sum == target){
                res.add(Arrays.asList(array[left], array[right]));
                left++;
                right--;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}
