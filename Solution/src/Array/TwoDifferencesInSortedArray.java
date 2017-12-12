package Array;

import java.util.HashMap;

/*
A = {1, 2, 3, 6, 9}, target = 2, return {0, 2} since A[2] - A[0] == 2.
A = {1, 2, 3, 6, 9}, target = -2, return {2, 0} since A[0] - A[2] == 2.
Given a sorted array A, find a pair (i, j) such that A[j] - A[i] is identical to a target number(i != j).

If there does not exist such pair, return a zero length array.
 */
public class TwoDifferencesInSortedArray {
    public int[] twoDiff(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i] + target, i);
                map.put(array[i] - target, i);
            }else{
                //要注意顺序
                if(target >= 0 ){
                    return new int[]{map.get(array[i]), i};
                }else{
                    return new int[]{i, map.get(array[i])};
                }
            }
        }
        return new int[]{};
    }
}
