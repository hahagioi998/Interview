package Array.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return res;
        }
        int m = matrix.length;
        // int n = matrix.length[0]; wrong!
        int n = matrix[0].length;
        int left = 0; //column
        int right = n - 1;
        int up = 0;//row
        int down = m - 1;

        while(left < right  && up < down){
            //add columns, fixed row
            for(int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }
            //need to +1 and -1 here because overlapping with left and right
            for(int i = up + 1; i <= down - 1; i++){
                res.add(matrix[i][right]);
            }

            for(int i = right; i >= left; i--){
                res.add(matrix[down][i]);
            }

            for(int i = down - 1; i >= up + 1; i--){//
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        //nothing left
        if(left > right || up > down){
            return res;
        }
        //one column left
        if(left == right){
            for(int i = up; i <= down; i++){//go through all rows, one column
                res.add(matrix[i][left]);
            }
        }else{
            //one row left
            for(int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }
        }
        return res;
    }
}
