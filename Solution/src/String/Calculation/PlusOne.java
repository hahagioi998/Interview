package String.Calculation;

//正常的整数加减法只能支持有限的位数，不能支持这种几千，几万位的元算，但是这些高精度的题目可以支持，所以叫做高精度问题，考察计算机知识和算法的基本功。
public class PlusOne {
    // The complexity is O(1)
    // f(n) = 9/10 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)

    public int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            //因为是array，可以直接覆盖掉
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        //最后的carry的处理
        if(carries == 0)
            return digits;

        //不然就要生成新的array
        int[] rst = new int[digits.length+1];
        //最开头的是1
        rst[0] = 1;
        //然后把digits copy过来
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
    }

}
