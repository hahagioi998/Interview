package com.company;

import java.util.*;

public class Main {
    int total = 0;
    public int minDifference(int[] array) {
        // Write your solution here.
        int[] min = new int[]{Integer.MAX_VALUE};
        for(int i : array){
            total += i;
        }
        StringBuilder sb = new StringBuilder();
        helper(array, 0, min, 0, 0);
        return min[0];
    }

    private void helper(int[] array, int index, int[] min, int count, int sum){
        // if(index > array.length/2){ //not correct, because each level represents element, some element are not choosen
        if(index == array.length){
            return;
    }

     sum += array[index];
        count++;
//    int sum = Integer.valueOf(String.valueOf(sb));
        if(count == array.length/2){
            min[0] = Math.min(min[0], Math.abs((total - sum) - sum));
        }
    helper(array, index + 1, min, count, sum);
     sum -= array[index];
     count--;
    helper(array, index + 1, min, count, sum);// still has to do index + 1
}
    public static void main(String[] args) {
	// write your code here
        Main solution = new Main();
//        int[][] array = new int[][]{new int[]{1,3}, new int[]{2,4}};
        int[] array = new int[]{2, 9, 3, 1, 1};
        int[][] matrix = new int[][]{new int[]{0,1,0}};
//        System.out.println(solution.largest(array));
//        solution.rotate(matrix);
        System.out.println(solution.minDifference(array));
//        System.out.println(solution.reverseWords(" an apple ").length( ));

    }
}
