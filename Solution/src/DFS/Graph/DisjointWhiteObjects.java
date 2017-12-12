package DFS.Graph;

public class DisjointWhiteObjects {
    public int whiteObjects(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){// int array
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int i, int j){
        if( i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 1){
            return;
        }
        matrix[i][j] = 1;// set visited otherwise stackoverflow

        dfs(matrix, i + 1, j);
        dfs(matrix, i, j + 1);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j - 1);
    }
}
