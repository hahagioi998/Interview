package String.Calculation;
// m*n X n*p = m *p row乘以column
//the column number in one should match with the row number in the other
public class MatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
    int m = A.length;
    int n = A[0].length;

    int p = B[0].length;

    int[][] C = new int[m][p];
        //row乘以column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                //还剩n,column in A and row in B
                for (int k = 0; k < n; k++) {
                    //fix the row in A * fix the column in B
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
    }
        return C;
}
}
