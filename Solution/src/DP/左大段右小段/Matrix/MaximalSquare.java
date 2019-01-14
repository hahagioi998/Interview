package DP.左大段右小段.Matrix;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
      if (matrix == null || matrix.length == 0) {
        return 0;
      }
      int n = matrix.length;
      int m = matrix[0].length;
      int[][] dp = new int[n][m];
      int result = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (i == 0 || j == 0) {//initialize
            dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
          } else if (matrix[i][j] == '1') {//only update when current value = 1
            dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);//Math.min only takes two values
            dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
            //dp的值取决于上，左，斜，取最小值
          }

          result = Math.max(result, dp[i][j]);
        }
      }
      //length只是边长
      return result;
    }

  public static void main(String[] args) {
    MaximalSquare maximalSquare = new MaximalSquare();
    char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    maximalSquare.maximalSquare(matrix);

  }
}
