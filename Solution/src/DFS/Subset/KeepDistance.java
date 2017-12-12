package DFS.Subset;

import java.util.Arrays;
//你说的限制条件是指backtracking每层应该做什么么？一般想不明白的时候可以手动走个例子，把问题形象化有助于思考。
//具体在backtracking的每一层，可以做的事情是任选一个数字放到当前位置上，这同时确定了对应数字的位置。检查这对应数字的位置是否为空，如果有其他数字则回溯，否则往下一层继续走，直到填满整个array。
public class KeepDistance {
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

        for(int i = index; i < 2*k; i++) {
            if(valid(res, num, i)) { //当前位置和对应位置为空，就向下走
                res[i] = num;
                if (i + num + 1 < res.length) {
                    res[i + num + 1] = num; //填两个
                } else {
                    res[i - num - 1] = num;
                }
                //start from index, pick index in ascending order
                if (helper(res, k, num + 1, i + 1)) {//下一层
                    return true;//stop backtracking
                }

                res[i] = 0;
                if (i + num + 1 < res.length) {
                    res[i + num + 1] = 0; //填两个
                } else {
                    res[i - num - 1] = 0;
                }
            }
        }

        return false;
    }

    private boolean valid(int[] res, int num, int i){
        if( (i + num + 1) < res.length && res[i + num + 1] == 0 && res[i] == 0){
            return true;
        }

        if( (i - num - 1) >= 0 && res[i - num - 1] == 0 && res[i] == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        boolean[] B = new boolean[A.length];
        KeepDistance i = new KeepDistance();
        System.out.println(Arrays.toString(i.keepDistance(3)));
    }
}
