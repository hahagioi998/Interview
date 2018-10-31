package DP.左大段右小段.Matrix;

/**
 * If we should left shift every element and put 0 at each empty position to make it a regular matrix, then our problem looks like minimum cost path.
 So, after converting our input triangle elements into a regular matrix we should apply the dynamic programmic concept to find the maximum path sum.
 Applying, DP in bottom-up manner we should solve our problem as:
 Example:

 3
 7 4
 2 4 6
 8 5 9 3

 Step 1 :
 3 0 0 0
 7 4 0 0
 2 4 6 0
 8 5 9 3

 Step 2 :
 3  0  0  0
 7  4  0  0
 10 13 15 0

 Step 3 :
 3  0  0  0
 20 19 0  0

 Step 4:
 23 0 0 0

 output : 23
 */
public class MaximumTriangleSum {
    //m = 2 so start from the second last row
    //or create a matrix that's larger, and use m as 3
    int maxPathSum(int tri[][], int m, int n)
    {
        // loop for bottom-up calculation
        //i是row，j是column
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                // for each element, check both
                // elements just below the number
                // and below right to the number
                // add the maximum of them to it
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i+1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }

        // return the top element
        // which stores the maximum sum
        return tri[0][0];
    }

    /* Driver program to test above functions */
    int main()
    {
        int tri[][] = {{1, 0, 0},
        {4, 8, 0},
        {1, 5, 3}};
        return 0;
    }
}
