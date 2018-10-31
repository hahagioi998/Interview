package Sort;
//average和best都是Θ(n^2)
//Auxiliary Space: O(1)
//The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
//选出最小的换，所以选出来的是index
public class SelectionSort {
    public int[] solve(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }

        //array.length - 1没得比了，所以就停在倒数第二个
        for(int i = 0; i < array.length - 1; i++) {
            //预定最小的index，用index因为换的时候方便
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                //在剩下的遍历一遍，才能找到最小的值的index，所以需要min来记录
                if(array[j] < array[min]){
                    min = j;
                }
            }
            //换
            swap(array, i, min);
        }

        return array;
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
