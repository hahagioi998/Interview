package Array.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here.
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            int left = i + 1;
            int right = array.length - 1;
            //skip duplicates for both i and left
            if(i > 0 && array[i] == array[i - 1]){//i will go out of bounds using while
                continue;
            }
            while(left < right){
                int sum = array[left] + array[right] + array[i];
                if(sum == target){
                    res.add(Arrays.asList(array[left], array[right], array[i]));
                    left++;
                    // right--;
                    while(left < right && array[left] == array[left - 1]){//left < right
                        left++;
                    }
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
