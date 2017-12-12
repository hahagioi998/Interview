package Array;

import java.util.ArrayList;
import java.util.List;
/*
Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. Return the largest number and 2nd largest number.
 {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
 */
public class LargestAndSecondLargest {
    static class Element {
        int val;
        List<Integer> list;
        Element(int val) {
            this.val = val;
            this.list = new ArrayList<>();
        }
    }

    private void swap(Element[] array, int left, int right) {
        Element temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private Element[] convert(int[] array) {
        Element[] elements = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            elements[i] = new Element(array[i]);
        }
        return elements;
    }

    //比较indices pair i和 largerlength -1 -i
    //put the smaller value into the larger value comparison list
    private void compareAndSwap(Element[] elements, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (elements[i].val < elements[length - i - 1].val) {
                swap(elements, i, length - i - 1);
            }
            //因为swap了，所以elements[i]一定更大
            elements[i].list.add(elements[length - i - 1].val);
        }
    }
    public int[] largestAndSecond(int[] array) {
        // Write your solution here.
        // The first element is the largest number,
        // the second element is the second largest number.
        Element[] elements = convert(array);
        int length = array.length;

        //不断两两比较，知道最后剩1个为止
        while (length > 1) {
            compareAndSwap(elements, length);
            length = (length + 1) / 2;
        }

        int second = Integer.MIN_VALUE;
        for (int num : elements[0].list) {
            second = Math.max(second, num);
        }
        return new int[]{elements[0].val, second};
    }
}
