package BinarySearch.BasicBinarySearch;

public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }

        int start = 0, end = array.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(array[mid] < target){
                start = mid + 1; //avoid infinite loop
            }else if(array[mid] > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}
