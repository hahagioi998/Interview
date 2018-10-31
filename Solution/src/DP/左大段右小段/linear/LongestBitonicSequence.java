package DP.左大段右小段.linear;
/*
Bitonic subsequence first increases and then decreases
Given an array with all integers,  a sub-sequence of it is called Bitonic if it is first sorted in an ascending order, then sorted in a descending order. How can you find the length of the longest bitonic subsequence.

Assumptions:

The given array is not null.
Corner Cases:

A subsequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
Examples:

{1, 3, 2, 1, 4, 6, 1}, the longest bitonic sub sequence is {1, 3, 4, 6, 1}, length is 5.
 */
public class LongestBitonicSequence {
    public int longestSequence(int arr[]){
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];

        //initialize
//        for(int i=0; i < arr.length; i++){
//            lis[i] = 1;
//            lds[i] = 1;
//        }

        for(int i= 0 ; i < arr.length; i++){
            //lis是记长度的，不是记具体的数字
            lis[i] = 1;
            for(int j= 0; j < i ; j++){
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for(int i = arr.length-1; i >=0 ; i--){
            lds[i] = 1;
            for(int j = arr.length-1; j > i; j--){
                if(arr[i] > arr[j]){
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            //because we initialized the same index twice
            if(max < lis[i] + lds[i] - 1){
                max = lis[i] + lds[i] - 1;
            }
        }
        return max;
    }

    public static void main(String args[]){
        LongestBitonicSequence bs = new LongestBitonicSequence();
        int[] arr = {1,4,3,7,2,1,8,11,13,0};
        int[] arr2 = {1, 3, 2, 1, 4, 6, 1};
        int r = bs.longestSequence(arr2);
        System.out.println(r);

    }

}
