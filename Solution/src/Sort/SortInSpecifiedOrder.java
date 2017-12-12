package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
public class SortInSpecifiedOrder {
    public int[] sortSpecial(int[] A1, int[] A2) {
        //convert to Integer array
        Integer[] refArray = toIntegerArray(A1);

        //重点是采用了自定义的comparator进行sort
        Arrays.sort(refArray, new MyComparator(A2));

        //转成Integers再转换回来
        for(int i = 0; i < refArray.length; i++){//convert back to int array
            A1[i] = refArray[i];
        }
        return A1;
    }

    private Integer[] toIntegerArray(int[] array){
        Integer[] refArray = new Integer[array.length];
        for(int i = 0; i < array.length; i++){
            refArray[i] = array[i];
        }
        return refArray;
    }

    //这里要记住，就是 static class 直接 implents Comparator
    static class MyComparator implements Comparator<Integer> {//class
        private Map<Integer, Integer> map;

        //constructor，把int[] a2里元素和对应的index取出来
        //index恰好说明了a2里面的元素顺序
        public MyComparator(int[] array){
            map = new HashMap<Integer, Integer>();
            for(int i = 0; i < array.length; i++){
                map.put(array[i], i);//store value and index
            }
        }

        @Override
        public int compare(Integer i1, Integer i2){//compare all int in refArray
            //在用a2里面的index来比较a1里面的数字
            Integer index1 = map.get(i1);//find index of numbers in array1
            Integer index2 = map.get(i2);

            //都存在在a2里，或者都不在a2就自然排序
            if(index1 != null && index2 != null){//map.containskey(index1)

                return index1.compareTo(index2);

            }else if(index1 == null && index2 == null){
                return i1.compareTo(i2);
            }

            //只有一方在a2里，那在的一方要在前面
            return index1 != null? -1 : 1; //the values exit in array2 will get ahead
        }
    }
}
