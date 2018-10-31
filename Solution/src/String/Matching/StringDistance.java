package String.Matching;
/*
Given an array of strings, and two different string s and t. We need to return the smallest indices difference between the two given strings.

Return -1 if we can not find s or t in the array.

Assumptions:

The given array is not null, none of the strings in the array is null.
s and t are different and they are not null.
Examples:

array =  {"this", "is", "a", "is", "fox", "happy"}, the distance of "fox" and "is" is 1.
 */
//难点在于array里有重复的string,不能用hashmap了
//所以就直接找，然后用Math.min找最小距离
public class StringDistance {
    public static int distance(String[] array, String s, String t) {
        //注意min开始要是max value，通过不断更新min
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(s))
                p1 = i;

            if (array[i].equals(t))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                //都找到了以后更新
                min = Math.min(min, Math.abs(p1 - p2));
        }

        //如果找不到
        if(p1 == -1 || p2 == -1){
            return -1;
        }else{
            return min;
        }
    }

    public static void main(String[] args){
        String[] array = new String[]{"b","c","b","b","b","c","a","a","a"};
        System.out.println(distance(array, "a", "b"));
    }
}
