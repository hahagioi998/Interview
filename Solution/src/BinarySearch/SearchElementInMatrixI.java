package BinarySearch;
//binary search 2D->1D
public class SearchElementInMatrixI {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }

        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        //end是最后一个index
        int start = 0, end = row * column - 1;
        //用<=二分法，等于的话就一定要抛，不然相等再进去的话就会死循环
        while(start <= end){
            int mid = start + (end - start) / 2;

            //找这个数字row = mid/column， colun是mid%column
            int number = matrix[mid / column][mid % column];

            if(number == target){
                //找到
                return true;
            }else if(number > target){
                //想成是1D
                //可以抛弃，用-1
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;

    }
}
