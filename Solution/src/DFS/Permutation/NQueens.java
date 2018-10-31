package DFS.Permutation;

import java.util.ArrayList;
import java.util.List;

//time complexity is O(n* n!)
//space complexity is O(n)
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();//one way of placing queens
        helper(res, cur, n);
        return res;
    }


    private void helper(List<List<Integer>> res, List<Integer> cur, int n){
        if(cur.size() == n){
            res.add(new ArrayList<Integer>(cur));//need to conver it to arraylist
            return;
        }

        for(int i = 0; i < n; i++){
            if(valid(cur, i)){//treating i as the column to try here
                cur.add(i);
                helper(res, cur, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int column){
        // and get the row of the next queen to be placed
        int row = cur.size();
        for(int i = 0; i < row; i++){
            //get index(position) = column of queen that has been placed
            //the column with same index can't be placed
            // the distance between row(new queen) to row(old queen) is row - i
            // the distance between column(new queen) to column of(old queen) Math.abs(cur.get(i) - column)
            // should be the same, other wise it's diagonal
            //diagonal Math.abs(cur.get(i) - column) == row - i
            if(cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i){
                return false;
            }
        }
        return true;
    }



    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        List<Integer> recordCol = new ArrayList<>();//必须是Integer
        dfs(res, cur, n, recordCol);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> cur, int n, List<Integer> recordCol) {

        if(cur.size() == n) {
            //这里一定要记得！！！
            for(int i = 0; i < cur.size(); i++) {
                if(cur.get(i).length() < n) {
                    StringBuilder sb = new StringBuilder(cur.get(i));
                    while(sb.length() < n){
                        sb.append(".");
                    }
                    cur.set(i, sb.toString());
                }

            }
            res.add(new ArrayList<String>(cur));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(isValid2(recordCol, i)) {
                recordCol.add(i);

                sb.append("Q");
                // while(sb.length() < n) {
                //     sb.append(".");
                // }
                cur.add(sb.toString());

                dfs(res, cur, n, recordCol);

                cur.remove(cur.size() - 1);
                recordCol.remove(recordCol.size() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(".");
            } else {
                sb.append(".");
            }
        }
    }

    public Boolean isValid2(List<Integer> cur, int col) {
        for(int i = 0; i < cur.size(); i++) {
            //要用abs
            if(cur.get(i) == col || (Math.abs(i - cur.size()) == Math.abs(cur.get(i) - col))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }


}
