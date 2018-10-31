package DP.左大段右小段.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]



  [4,1,8,3,0]
  [
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
因为有overlapping branches
思路就是每一层都选最小的 + 上一层最小的,从最后一层开始
The idea is simple.

Go from bottom to top.

We start form the last row

Each number add the smaller number of two numbers that below it.

And finally we get to the top we the smallest sum.
From there, the min pathsum at the ith node on the kth row would be the lesser of the pathsums of its two children plus the value of itself, i.e.:
 */
public class MinimumTriangleSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        //这里就存每一层，层数和每层的元素个数是一样的
        int[] A = new int[triangle.size()+1];
        //i是layer，从最后一层开始
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j=0; j < triangle.get(i).size(); j++){
                //triangle.get(i).get(j) 每一层的元素
                //A[j] A[j+1] 就是一个node的两个branches
                A[j] = Math.min(A[j], A[j+1])+ triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args){
        MinimumTriangleSum sol = new MinimumTriangleSum();
        ArrayList<Integer> level1 = new ArrayList<>();
        level1.add(2);
        ArrayList<Integer> level2 = new ArrayList<>();
        level2.add(3);
        level2.add(4);
        ArrayList<Integer> level3 = new ArrayList<>();
        level3.add(6);
        level3.add(5);
        level3.add(7);
        ArrayList<Integer> level4 = new ArrayList<>();
        level4.add(4);
        level4.add(1);
        level4.add(8);
        level4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(level1);
        triangle.add(level2);
        triangle.add(level3);
        triangle.add(level4);

        System.out.println(sol.minimumTotal(triangle));
    }
}
