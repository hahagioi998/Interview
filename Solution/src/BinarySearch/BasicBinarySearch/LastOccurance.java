package BinarySearch.BasicBinarySearch;

public class LastOccurance {
    public int lastOccur(int[] array, int target) {
        if(array == null || array.length == 0){
        return -1;
    }

    int left = 0, right = array.length - 1;
    while(left < right - 1){
        int mid = left + (right - left)/2;
        //先移动left
        if(array[mid] <= target){//array[mid]
            left = mid;
        }else{
            right = mid;
        }
    }

    if(array[right] == target){
        return right;
    }else if(array[left] == target){
        return left;
    }
    return -1;
}
}
