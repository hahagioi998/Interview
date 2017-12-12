package String.SlidingWindow;

import java.util.HashMap;

/*
Method 1 ( Brute force solution )
1- Generate all substrings of string1 (“this is a test string”)
2- For each substring, check whether the substring contains all characters of string2 (“tist”)
3- Finally, print the smallest substring containing all characters of string2.


Method 2 ( Efficient Solution )

1- First check if length of string is less than
   the length of given pattern, if yes
       then "no such window can exist ".
2- Store the occurrence of characters of given
   pattern in a hash_pat[].
3- Start matching the characters of pattern with
   the characters of string i.e. increment count
   if a character matches
4- Check if (count == length of pattern ) this
   means a window is found
5- If such window found, try to minimize it by
   removing extra characters from beginning of
   current window.
6- Update min_length.
7- Print the minimum length window.
*/
//s1= “The given test strings”
//
//        s2: “itsst”
//
//        Output string: “st stri”
public class SmallestSubstringContainingAllCharactersOfAnotherString {
    //sliding window是由i和j来维护的，substring containing all characrers的长度是不固定的
    //改成hashmap比较好
    int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }

    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] targethash = new int[256];
        //target的char个数
        int targetnum = initTargetHash(targethash, Target);

        int sourcenum = 0;
        //fast和slow pointers
        int j = 0, i = 0;

        for(i = 0; i < Source.length(); i++) {
            //找到了一个match
            if(targethash[Source.charAt(i)] > 0) {
                sourcenum++;
            }
            //不管match不match都减掉
            targethash[Source.charAt(i)]--;

            //当找到match个数和target一样多的时候
            while(sourcenum >= targetnum) {
                //
                if(ans > i - j + 1) {
                    //更新长度和min string的长度和minstring
                    ans = Math.min(ans, i - j + 1);
                    minStr = Source.substring(j, i + 1);
                }

                //把最左端的加回去
                targethash[Source.charAt(j)]++;
                if(targethash[Source.charAt(j)] > 0)
                    sourcenum--;
                //移动slow pointer
                j++;
            }
        }
        return minStr;
    }
}
