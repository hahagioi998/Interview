package DP;
/*
Given a string S, find the longest palindromic substring in S.

Assumptions
There exists one unique longest palindromic substring.
The input S is not null.
Examples
Input:     "abbc"
Output:  "bb"

Input:     "abcbcbd"
Output:  "bcbcb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = s.length() - 1;
        int max = 0;
        boolean[][] isP = new boolean[len][len];
        for(int i = 1; i < len; i++){
            for(int j = 0; j <= i; j++){//<= i
                if(s.charAt(j) == s.charAt(i)){
                    if(j + 1 > i - 1 || isP[j + 1][i - 1]){// ||
                        //j + 1 > i - 1 when j and i are next to each other or  when j = i
                        isP[j][i] = true;
                    }
                }

                if(isP[j][i] && max < i - j + 1) {// i - j + 1 = 2 - 1 + 1 = 2 length of palindrome
                    max = i - j + 1; //update length
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);//substring
    }
}
