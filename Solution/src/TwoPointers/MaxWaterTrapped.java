package TwoPointers;

public class MaxWaterTrapped {
    public int maxTrapped(int[] array) {
        // Write your solution here.
        if(array.length== 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int lmax = array[left];//left bound
        int rmax = array[right];//right bound
        int res = 0;
        while(left < right){
            //left bound - left; right bound - right
            if(array[left] <= array[right]){//compare value
                res += Math.max(0, lmax - array[left]);//if lmax - arrray[i] > 0 water trapped, < 0 update new left bound
                lmax = Math.max(array[left], lmax);//get the larger value as left bound
                left++;
            }else{
                res += Math.max(0, rmax - array[right]);
                rmax = Math.max(array[right], rmax);
                right--;
            }
        }
        return res;
    }
}
