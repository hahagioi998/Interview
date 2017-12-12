package DP.左大段右小段.Matrix;
/*
You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

1) Optimal Substructure
The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1).
So minimum cost to reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”.

minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
 */
public class MinCostPath {
    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];

        tc[0][0] = cost[0][0];

        //多出来一行一列，要initialize
        /* Initialize first column of total cost(tc) array，row is a variable，只能向上一行看 */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array，只能向前一列看 */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1],
                        tc[i-1][j],
                        tc[i][j-1]) + cost[i][j];

        return tc[m][n];
    }
//
//    int minCost(int cost[R][C], int m, int n)
//    {
//        if (n < 0 || m < 0)
//            return INT_MAX;
//        else if (m == 0 && n == 0)
//            return cost[m][n];
//        else
//            return cost[m][n] + min( minCost(cost, m-1, n-1),
//                    minCost(cost, m-1, n),
//                    minCost(cost, m, n-1) );
//    }
//
//    /* A utility function that returns minimum of 3 integers */
//    int min(int x, int y, int z)
//    {
//        if (x < y)
//            return (x < z)? x : z;
//        else
//            return (y < z)? y : z;
//    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                minCost(cost,2,2));
    }
}
