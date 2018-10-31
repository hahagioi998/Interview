package String.Matching;

/*
Implement regular expression matching with support for '.' and '*'.
和wildcard不一样的是，这里*对应的前面的字符

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
/*
Here are some conditions to figure out, then the logic can be very straightforward.

1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*':
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
                    state[0][j] = true;
                }
            }
        }

        /*

           for(int i = 2; i <= n; i++){
            if(pc[i - 1] == '*'){
                dp[0][i] = dp[0][i - 2]; // *可以消掉c*
                }
            }
         */
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        state[i][j] = state[i][j - 2];
                    } else {
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }



    public boolean isMatch2(String s, String p) {
        //Java note: s.substring(n) will be "" if n == s.length(), but if n > s.length(), index oob error

        int i = 0, j = 0;
        //you don't have to construct a state machine for this problem

        if (s.length() == 0) {
            return checkEmpty(p);
        }

        if (p.length() == 0) {
            return false;
        }

        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do

        if (p.length()>1){
            d2 = p.charAt(1);
        }

        if (d2 == '*') {
            if (compare(c1, d1)) {
                //fork here: 1. consume the character, and use the same pattern again.
                //2. keep the character, and skip 'd1*' pattern

                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch2(s.substring(1), p) || isMatch2(s, p.substring(2));
            }
            else {
                return isMatch2(s, p.substring(2));
            }
        }
        else {
            if (compare(c1, d1)) {
                return isMatch2(s.substring(1), p.substring(1));
            }
            else {
                return false;
            }
        }
    }

    public boolean compare(char c1, char d1){
        return d1 == '.' || c1 == d1;
    }

    public boolean checkEmpty(String p) {
        if (p.length() % 2 != 0) {
            return false;
        }

        for (int i = 1; i < p.length(); i+=2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}


