package Sort;

//这样会改变顺序
public class Move0sToEnd1 {
    public int[] moveZero(int[] array) {
        int i = 0, j = array.length - 1;
        //i = j也没有意义
        while(i < j) {
            if(array[i] == 0 && array[j] != 0) {
                swap(array, i, j);
                i++;
                j--;
            }

            //注意跳过的条件，我们希望i是0，j不是0
            if(array[i] != 0) {
                i++;
            }

            if(array[j] == 0) {
                j--;
            }
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
