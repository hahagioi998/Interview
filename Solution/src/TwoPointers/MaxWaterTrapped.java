package TwoPointers;
//相向而行，把这个问题分成相向而行的扫描
//一个是向右取空间，一个向左取空间，直到相遇，要学会这个
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
                //当左边比右边低的时候才能确定这个从左向右的区间是一定可以被围起来的，不管中间的是更高还是更低
                //array[left]比lmax先更新，lmax - array[left]这样就可以保证从左向右取的是右边的空间
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
