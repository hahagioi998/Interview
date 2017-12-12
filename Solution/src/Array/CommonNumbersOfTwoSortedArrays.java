package Array;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here.
        //use two points or two hashmaps
        // if(A.length == 0 || B.length == 0){
        //   return new ArrayList<Integer>(0);
        // }
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                res.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}
