package DP.左大段右小段.Matrix.SingleString;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class PalindromePartition {
    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }


    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
