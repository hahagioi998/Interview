package DFS.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of size n, generate and print all possible combinations of r elements in array.
// For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
public class CombinationOfSizeK {
    public List<List<Integer>> combination(int arr[], int k){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        combinationUtil(arr,k,0,result, cur);
        return result;
    }
    //分四层，每层加或者不加，
    private void combinationUtil(int arr[],int k, int pos,List<List<Integer>> result, List<Integer> cur){
        //这个cur size的检查一定要放 pos的前面
        if(cur.size() == k){
            result.add(new ArrayList<>(cur));
            return;
        }

        //pos表示的是array的index，所以是和array的长度来比较
        if(pos == arr.length){
            return;
        }

            cur.add(arr[pos]);
            combinationUtil(arr, k, pos + 1, result, cur);
            cur.remove(cur.size() - 1);
            combinationUtil(arr, k, pos + 1, result, cur);

    }

    public static void main(String args[]){
        CombinationOfSizeK kk = new CombinationOfSizeK();
        int arr[] = {1,2,3,4};
        List<List<Integer>> res = kk.combination(arr, 2);
        for(List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
