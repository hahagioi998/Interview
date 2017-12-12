package DFS.Subset;

import java.util.Arrays;
//你说的限制条件是指backtracking每层应该做什么么？一般想不明白的时候可以手动走个例子，把问题形象化有助于思考。
//具体在backtracking的每一层，可以做的事情是任选一个数字放到当前位置上，这同时确定了对应数字的位置。检查这对应数字的位置是否为空，如果有其他数字则回溯，否则往下一层继续走，直到填满整个array。
public class KeepDistanceMethod2 {
    public int[] keepDistance(int k) {
        int[] res = new int[2 * k];
        if(helper(res, k, 1, 0)){
            return res;
        }
        return null;
    }

    private boolean helper(int[] res, int k, int num, int index){
        if(num == k + 1){
           return true;
        }

        if(valid(res, num, index)){
            if (index + num + 1 < res.length) {
                res[index + num + 1] = num; //填两个
            } else {
                res[index - num - 1] = num;
            }
            helper(res, k, num + 1, index + 1);

            res[index] = 0;
            if (index + num + 1 < res.length) {
                res[index + num + 1] = 0; //填两个
            } else {
                res[index - num - 1] = 0;
            }

            helper(res, k, num, index + 1);
        }

        return false;
    }

    private boolean valid(int[] res, int num, int i){
        if( i + num + 1 < res.length && res[i + num + 1] == 0 && res[i] == 0){
            return true;
        }

        if(i - num - 1 >= 0 && res[i - num - 1] == 0 && res[i] == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        boolean[] B = new boolean[A.length];
        KeepDistance i = new KeepDistance();
        System.out.println(Arrays.toString(i.keepDistance(8)));
    }
}

