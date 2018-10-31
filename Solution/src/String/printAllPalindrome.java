package String;

import java.util.HashSet;
import java.util.Set;

public class printAllPalindrome {

        /*
        The idea is to simply pick every character and move both the sides till
        the characters are same on the end. If they are not, then you break of
        the loop because if the substring is not a palindrome than the bigger
        string will not be a plaindrome too. TimeComplexity: O(n^2).
        Brute force is O(n^3).
        Generation of all substring of a string is itself O(n^2),
        hence this is an optimal solution.
        */
        //palindrome有两种情况，奇偶数，偶数的话j和i是重合的
        //所以针对每个数有三个loop，一定要check substring，所以肯定是两个loop，n^2，另一个loop是要用分奇数偶数的情况
    //要学会分析时间复杂度和这种向前插入字符
        public static Set<String> printAll(String s) {
            Set<String> res = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                int j = i, k = i + 1;
                //单独的一个字符也是palindrome
                res.add(s.charAt(i) + "");

                //分奇数偶数两种情况
                for (int it = 0; it < 2; it++) {
                    //奇数，把当前的char这个当做中间点
                    if (it == 1) {
                        j = i - 1;
                        k = i + 1;
                        //这是一条新的string，要重新setlength
                        sb.setLength(0);
                        //加入中间的点
                        sb.append(s.charAt(i));
                    }

                    //向两边走走到头，一边走一边比较
                    while (j >= 0 && k < s.length()) {
                        if (s.charAt(j) == s.charAt(k)) {
                            //要插入到前一位
                            sb.insert(0, s.charAt(j));
                            //另一个就可以append
                            //同时把sb加入res
                            res.add(sb.append(s.charAt(k)).toString());

                            j--;
                            k++;
                        } else
                            //如果有不同就break
                            break;
                    }
                }
            }
            return res;
        }

        public static void main(String[] args) {
            for (String s : printAll("abcbad"))
                System.out.println(s);
        }
    }

