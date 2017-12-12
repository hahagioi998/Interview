package BinarySearch;

//因为是sorted array所以只要找到target，然后向两边比较absolute value取值就好了
public class KClosestinSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        while(array == null || array.length == 0){
            return array;
        }
        if(k == 0){
            return new int[0];
        }
        int[] res = new int[k];
        int left = 0, right = array.length - 1;
        while(left < right - 1){ //相邻
            int mid = left + (right - left)/2;
            if(array[mid] <= target){//<=
                left = mid;
            }else{
                right = mid;
            }
        }

        for(int i = 0; i < k; i ++){//left和right都不能过界
            if(right >= array.length || (left >= 0 && (Math.abs(target - array[left]) <= Math.abs(array[right] - target)))){
                res[i] = array[left--];
            }else{
                res[i] = array[right++];
            }
        }
        return res;
    }
}
