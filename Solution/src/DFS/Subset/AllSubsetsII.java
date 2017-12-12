package DFS.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII {
    public List<String> subSets(String set) {
        // Write your solution here.

        List<String> res = new ArrayList<>();
        if(set == null){
            return res;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);//use sort!! to make duplicates consecutive
        StringBuilder sb = new StringBuilder();
        helper(res, array, sb, 0);
        return res;
    }

    private void helper(List<String> res,char[] array, StringBuilder sb, int index){
        res.add(sb.toString());//add ""

        //index: pick element in ascending order, "index" is the smallest index we can pick for the subset
        for(int i = index; i < array.length; i++){
            //for consecutive duplicate elements, we only pick the first one
            if(i == index || array[i] != array[i - 1]){//works for consecutive duplicates
                //i != index when change status on the same level for the same position(level)
                //so we don't want to add the same char again for the same position
                sb.append(array[i]);
                helper(res, array, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);//user deleteCharAt
            }
        }
    }

    private void helper(int index, char[] set, StringBuilder sb, List<String> res) {
        if(index == set.length){
            res.add(sb.toString());
            return;
        }

        //加
        sb.append(set[index]);
        helper(index + 1, set, sb, res);
        sb.deleteCharAt(sb.length() - 1);//加了就要删
        //dedup
        while(index < set.length - 1 && set[index] == set[index + 1]){
            index++;
        }
        //不加
        helper(index + 1, set, sb, res);
    }
}
