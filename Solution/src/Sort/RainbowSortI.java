package Sort;

import java.util.Arrays;

/*
--i decrements i by 1 then gives you the value of i.

i-- gives you the value of i then decrements it by 1.

假如只有0和1要变成0在1前面，sort的方法就是把一个设定为基本点，然后抛另一个
0 1 2的话就先把2抛到后面，然后按照0和1处理，把0和1看做一个基本单位
 */
public class RainbowSortI {
    public int[] rainbowSort(int[] array) {
        // (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
        if (array == null || array.length == 0) {
            return array;
        }
        //记录左，右两个颜色位置，red左边都是-1，blue右边都是1，但不包括他们本身
        int red = 0, blue = array.length - 1;

        //don't have to have i++！！！
        //i也是从0开始， 要小于等于blue!!用while loop也不错
        for (int i = 0; i <= blue;) {
            //如果找到是第一个颜色，那就和第一个颜色的index换
            if (array[i] == -1) {
                //i++因为左边i是查过的
                swap(array, i++, red++);
            } else if (array[i] == 1) {
                //如果是第三个颜色，那就和最右边的换，但i不增加，因为右边没有查过可能会换过来别的颜色
                swap(array, i, blue--);
            } else {
                //如果i是中间的颜色那就可以不换
                i++;
            }
        }
        return array;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        RainbowSortI s = new RainbowSortI();
        int[] res = s.rainbowSort(new int[]{1, -1, 0, 1, 0});

        System.out.println(Arrays.toString(res));
    }
}
