package BinarySearch.BinarySearchCalculation;

public class Sqrt {
    public int sqrt(int x) {
        // binary search, suppose there a array of int 1 to x
        if(x == 0){//when x= 0
            return 0;
        }
        int left = 1, right = x;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            // if(mid * mid > x){  mid^2 gets too large and become negative
            if(mid > x/mid){
                right = mid;
            }else if(mid < x/mid){
                left = mid;
            }else{
                return mid;
            }
        }

        if(left * left <= x){
            return left;
        }else{
            return right;
        }
    }
}
