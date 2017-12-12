package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of list of Strings. Print cartesian product of lists.
         * input -> {"Hello", "World"} , {"Game"}, {"Go","Home"}
         * output ->
         * Hello Game Go
         * Hellow Game Home
         * World Game Go
         * World Game Home
         */
public class WordCombination {
    public List<List<String>> printCombinations(List<List<String>> input) {
        List<List<String>> result = new ArrayList<>(input.size());
        List<String> cur = new ArrayList<>();
        print(input, result, cur, 0);
        return result;
    }

    private void print(List<List<String>> input, List<List<String>> result, List<String> cur, int pos) {
        if(pos == input.size()){
            //这里别忘了要new ArrayList
            result.add(new ArrayList<String>(cur));
            return;
        }

        //用for loop因为这一层的状态多过于两个了
        for(int i = 0 ; i < input.get(pos).size(); i++){
            cur.add(input.get(pos).get(i));
            //这里是pos+1，不能是++，不然recursion返回就改变了
            print(input, result, cur,pos + 1);
            //这里一定是拿掉最后一个值
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String args[]){
        List<String> l1 = new ArrayList<>();
        l1.add("quick");
        l1.add("slow");

        List<String> l2 = new ArrayList<>();
        l2.add("brown");
        l2.add("red");

        List<String> l3 = new ArrayList<>();
        l3.add("fox");
        l3.add("dog");

        List<List<String>> input = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);

        WordCombination wc = new WordCombination();
        List<List<String>> res = wc.printCombinations(input);
                for(List<String> list : res) {
                    System.out.println(Arrays.toString(list.toArray()));
                }
    }
}
