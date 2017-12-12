package BinarySearch;
//写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
//
//        这个矩阵具有以下特性：
//
//        每行中的整数从左到右是排序的。
//        每一列的整数从上到下是排序的。
//        在每一行或每一列中没有重复的整数。
//每一个数字的上面和左边都比它小，这个算法可以选左下角或者右上角
//如果 target == 左下角元素（当前位置），那么已经完成任务！
//        如果 target > 左下角元素 matrix[m][0]，那么与 matrix[m][0] 同一列的元素全都小于 target， target 位于右边的矩阵 matrix[0..m][1..n]。
//        如果 target < 左下角元素 matrix[m][0]，那么与 matrix[m][0] 同一行的元素全都大于 target， target 位于上边的矩阵 matrix[0..m-1][0..n]。
//这个算法的复杂度是 O(m+n)。
public class Search2DMatrixII {
    public int searchMatrix(int[][] matrix, int target) {
        //r是row，从最底层开始
    int r = matrix.length - 1;
    //c是column，从第一列开始
    int c = 0;
    int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            //从左下角开始，matrix[r][c]是对角线的值
        if (target == matrix[r][c]) {
            //找到就
            ans++;
            r--;
            c++;
            continue;
        }
        if (target < matrix[r][c]) {
            //target比对角线小的话一定是row--
            r--;
        } else {
            c++;
        }
    }
        return ans;
    }
}
