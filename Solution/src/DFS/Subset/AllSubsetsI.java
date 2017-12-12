package DFS.Subset;

import java.util.ArrayList;
import java.util.List;
//in subset, ac 和ca是一样的，但是permutation 顺序是重要的
//abb
public class AllSubsetsI {
    public List<String> subSets(String set) {
        // time complexity 2^n
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();//list of string so need stringbuilder
        char[] chars = set.toCharArray();
//        helper(0, chars, sb, res);
        helper(0, sb, res, chars);
        return res;
    }

    private void helper(int index, char[] set, StringBuilder sb, List<String> res) {
        res.add(sb.toString());

        //start from index, pick index in ascending order
        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helper(i + 1, set, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void helper(int index, StringBuilder sb, List<String> res, char[] set) {
        //allsubsetofsizek we need to consider length
//        if(sb.length() == 3){
//            res.add(sb.toString());
//            return;
//        }

        if(index == set.length) { //base case, below the last level of tree
            res.add(sb.toString());// if we need to consider length, don't print here
            return;
        }

        //加
        sb.append(set[index]);
        helper(index + 1, sb, res, set);
        sb.deleteCharAt(sb.length() - 1);

        //不加
        helper(index + 1, sb, res, set);

    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 3, 4, 5 };
        boolean[] B = new boolean[A.length];
        AllSubsetsI i = new AllSubsetsI();
        System.out.println(i.subSets("abc"));

    }

}
