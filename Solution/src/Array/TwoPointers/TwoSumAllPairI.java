package Array.TwoPointers;

import java.util.*;
//A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here.
        // Arrays.sort(array);
        // List<List<Integer>> res = new ArrayList<>();
        // if(array == null || array.length == 0){
        //   return res;
        // }
        // int left = 0;
        // int right = array.length - 1;
        // while(left < right){
        //   int sum = array[left] + array[right];
        //   if(sum == target){
        //只是在这里加入到结果里面，用Arrays.asList
        //     res.add(Arrays.asList(left, right));
        //     left++;
        //     right--;
        //   }else if(sum > target){
        //     right--;
        //   }else{
        //     left++;
        //   }
        // }
        // return res;
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        //value is list because there are duplicate characters, so one char can have different indices
        for(int i = 0; i < array.length; i++){
            //在map里找组成target的另一块
            if(map.containsKey(target - array[i])){
                List<Integer> indices = map.get(target - array[i]);
                for(int j : indices){
                    //要记住这个arrays.aslist，j放前面
                    res.add(Arrays.asList(j, i));//i is larger index
                }
            }

            //没有这个数字的话，要创建一个index list
            if(!map.containsKey(array[i])){
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);//add all possible indices for i
        }
        return res;
    }
}
