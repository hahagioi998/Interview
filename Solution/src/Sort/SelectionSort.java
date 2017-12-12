package Sort;
//average和best都是Θ(n^2)
public class SelectionSort {
    public int[] solve(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }

        for(int i = 0; i < array.length - 1; i++){
            //预定最小的index，用index因为换的时候方便
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                //在剩下的里面找，比min更小的 index
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
