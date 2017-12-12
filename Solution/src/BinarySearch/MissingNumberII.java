package BinarySearch;

public class MissingNumberII {
    public Integer findMissing(int arr[]){
        //low number就是起始的这个值
        int lowNum = arr[0];
        int low = 0;
        int high = arr.length -1;
        int middle = (low + high)/2;
        while(low <= high){
            middle = (low + high)/2;
            //可以这样判断，因为这里间隔就是1
            //middle + 1 + lowNum 就是说arr[mid]比正确值更大，如果前一个值是正确的
            if(arr[middle] == (middle + 1 + lowNum) && middle-1 >=0 && arr[middle - 1] == (middle + lowNum - 1)){
                return middle + lowNum;
            } else if((middle + lowNum) == arr[middle]){
                //可以抛掉，到middle为止，包括mid都是正确的
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return null;
    }

    public static void main(String args[]){
        int arr[] = {3,4,5,6,7,8,9,10,11,12};
        int arr1[] = {-5,-4,-3,-1,0,1,2,3};
        MissingNumberII mn = new MissingNumberII();
        System.out.println(mn.findMissing(arr1));
    }
}
