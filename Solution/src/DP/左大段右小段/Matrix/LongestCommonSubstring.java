package DP.左大段右小段.Matrix;
/*
Find the longest common substring of two given strings.

Assumptions

The two given strings are not null
Examples

S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
在两个string之间的
 */
public class LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        // base case initialized to 0
        // the lcs ends with longest[i][j]

        // int[][] longest = new int[s.length() + 1][t.length() + 1];
        // int start = 0;
        // int max = 0;
        //   for(int i = 1; i <= s.length(); i++){
        //     for(int j = 1; j <= t.length(); j++){
        //       if(s.charAt(i - 1) == t.charAt(j - 1)){
        //         longest[i][j] = longest[i - 1][j - 1] + 1;
        //       }else{
        //         longest[i][j] = 0;//is not needed
        //       }
        //       if(longest[i][j] > max){
        //         max = longest[i][j];
        //         start = i - max;//i is actual index + 1
        //       }
        //   }
        //   }
        // return s.substring(start, start + max);
        int[][] longest = new int[s.length()][t.length()];//no extra space
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    if(i == 0 || j == 0){//initalize the first column and first row with having extra space
                        longest[i][j] = 1;
                    }else{
                        longest[i][j] = longest[i - 1][j - 1] + 1;
                    }
                    if(longest[i][j] > max){
                        max = longest[i][j];
                        start = i - max + 1;
                    }

                }
            }
        }
        return s.substring(start, start + max);
    }
}
