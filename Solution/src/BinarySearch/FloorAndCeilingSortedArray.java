package BinarySearch;
/*
Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
 */
public class FloorAndCeilingSortedArray {
    public int floor(int input[], int x){
        int low = 0;
        int high = input.length-1;
        while(low <= high){
            int middle = (low + high)/2;
            if(input[middle] == x || (input[middle] < x && (middle == input.length-1 || input[middle+1] > x))){
                //情况1是middle等于x，x存在array里
                //情况2是middle小于x但是mid+1大于x了，x不存在array里
                //情况3mid小于array，且mid是最后一个数
                return middle;
            }else if(input[middle] < x){
                //所以这里可以抛mid
                low = middle+1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }

    public int ceiling(int input[], int x){
        int low = 0;
        int high = input.length-1;
        while(low <= high){
            int middle = (low + high)/2;
            if(input[middle] == x || (input[middle] > x && (middle == 0 || input[middle-1] < x))){
                return middle;
            }else if(input[middle] < x){
                low = middle+1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int input[] = {1,2,5,6,11,15};
        FloorAndCeilingSortedArray foc = new FloorAndCeilingSortedArray();
        System.out.println(foc.floor(input, 15));
        System.out.println(foc.ceiling(input, 2));
    }
}
