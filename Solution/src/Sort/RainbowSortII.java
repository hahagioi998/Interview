package Sort;

import java.util.Arrays;

//想想看，不管是几色，是不是都可以用挡板的思路来实现？具体的细节可以根据挡板的定义走几个例子？另外，4色比如1，2，3，4，我们也可以把 1，2 group到一起看做一种颜色，3，4 group到一起看做一种颜色，这样是不是就可以先解决一个2色问题？后面的工作留给你自己。
//2. 对于N色sort，每次分成2组，把一组sort到左边，另一组sort到右边，然后如果一组里有超过2种颜色接着往下分组sort。总共有logk层，每一层要把array扫一遍就是O（nlogk）time，O（logk）space。但是我感觉这个也没比count sort好啊，count sort是O（n）time和space，是要根据注重时间还是空间决定吗？
//count sort是有局限性的，如果sort的东西不是primitive type，而是按照object的某个属性，那其实count sort没法用。而且本身这个题目可能考察的点就是swap和partition操作所以不让用count sort
//怎么sort四种颜色
public class RainbowSortII {
    public int[] rainbowSortII(int[] array) {
        // Write your solution here.
        if (array.length == 0){
            return array;
        }
        //i是第一种颜色
        int i = 0;
        int j = 0;
        //k是第四种颜色
        int k = array.length - 1;
        //先当成三种颜色sort
        //一定是<=
        //注意这里是
        while (j <= k) {
            if (array[j] == 0) {
                //i is cremented here
                swap(array, i++, j++);
            } else if (array[j] == 3) {
                swap(array, j, k--);
            } else {
                //把1和2当成一种颜色
                j++;
            }
        }

        //用i因为j已经超过k了，sort two colors
        while (i <= k) {
            if (array[i] == 1) {
                //颜色是1的话，就
                i++;
            } else {
                //k已经不是在array的最后了
                swap(array, i, k--);
            }
        }
        return array;
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args){
        RainbowSortII s = new RainbowSortII();
        int[] res = s.rainbowSortII(new int[]{1, 3, 2, 1, 0});

        System.out.println(Arrays.toString(res));
    }
}
