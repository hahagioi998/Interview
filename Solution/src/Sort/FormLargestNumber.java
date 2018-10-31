package Sort;

import java.util.Arrays;
import java.util.Comparator;
//{“54”, “546”, “648”, “88”}, the arrangement “8864854654” gives the largest value.
/*
In terms of Time and Space Complexity:
Let's assume:
the length of input array is n,
average length of Strings in s_num is k,
Then, compare 2 strings will take O(k).
Sorting will take O(nlgn)
Appending to StringBuilder takes O(n).
So total will be O(nklgnk) + O(n) = O(nklgnk).

Space is pretty straight forward: O(n).
 */
public class FormLargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        //这里已经sort完成了，剩下的要去掉前面的零

        String result = sb.toString();
        //看是不是都是0，其实只要看第一个char就好
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        //全部都是0
        if (index == result.length()) {
            return "0";
        }
        //去substring
        return result.substring(index);
    }
}

class NumbersComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        //组合更大的会在前面
        return (s2 + s1).compareTo(s1 + s2);
    }

    public static void main(String[] args){
        FormLargestNumber sol = new FormLargestNumber();
        int[] nums = new int[]{123,45,700,8};
        System.out.println(sol.largestNumber(nums));
    }
}
