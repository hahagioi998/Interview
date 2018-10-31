package Array.Matrix;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        // Write your solution here.
        int n = matrix.length;
        if(n <= 1){
            return;
        }
        //圈数
        int round = n/2;

        //level也是从0开始
        for(int level = 0; level < round; level++){
            //第几圈
            //可以直接做为每一圈第一排和第一列来用
            // ->
            //|
            //v
            int left = level;
            //-2因为-1才能是index，再-1因为每一圈的四个点是要被换的，然后再-level，level最开始是0
            int right = n - 2 - level;

            for(int i = left; i <= right; i++){
                //tmp是左上角
                int tmp = matrix[left][i];
                //n - 1 是index，然后再-i ，左上角 = 左下角，变的是行数
                matrix[left][i] = matrix[n - 1 - i][left];
                //左下角 = 右下角， 右下角变的是列数
                matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
                matrix[i][n - 1 - left] = tmp;
            }
        }
    }
}
