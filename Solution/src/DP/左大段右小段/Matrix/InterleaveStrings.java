package DP.左大段右小段.Matrix;
/*
Given three strings A, B and C. Determine if C can be created by merging A and B in a way that maintains the relative order of the characters in A and B.

Assumptions

none of A, B, C is null
Examples

C = "abcde", A = "acd", B = "be", return true
C = "abcde", A = "adc", B = "be", return false
 */
public class InterleaveStrings {
    public boolean canMerge(String a, String b, String c) {
        // Write your solution here.
        if((a.length() + b.length()) !=  c.length()){
            return false;
        }
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j <= b.length(); j++){
                if(i == 0 && j == 0){ //?
                    dp[i][j] = true;
                }
                if(i > 0 && c.charAt(i + j - 1) == a.charAt(i - 1)){// i has to be greater than 0
                    dp[i][j] |= dp[i - 1][j];//use or to add true or false
                }

                if(j > 0 && c.charAt(i + j - 1) == b.charAt(j - 1)){
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
