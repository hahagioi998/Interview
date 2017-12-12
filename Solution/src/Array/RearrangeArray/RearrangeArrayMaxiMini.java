package Array.RearrangeArray;

import java.util.Arrays;

//rearrange an array in maximum minimum form
//Input  : arr[] = {1, 2, 3, 4, 5, 6, 7}
//Output : arr[] = {7, 1, 6, 2, 5, 3, 4}
public class RearrangeArrayMaxiMini {
    public static int[] rearrange(int[] array){
        int[] res = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        int index = 0;
        while(left <= right){
            if(index == array.length - 1){
                res[index] = array[left];
                break;
            }
            if(index < array.length - 1) {
                res[index] = array[right];
                res[index + 1] = array[left];
            }
            left++;
            right--;
            index += 2;
        }
        return  res;
    }

    public static int[] rearrange2(int[] arr){
            int[] res = new int[arr.length];
            int left = 0;
            int right = arr.length - 1;
            boolean flag = true;

            // Store result in temp[]
            for (int i=0; i< arr.length; i++)
            {
                if (flag) //even true 0 2 4 6 8
                    res[i] = arr[right--];
                else //odd false 1 3 5 7 9
                    res[i] = arr[left++];
                //even to odd, odd to even
                flag = !flag;
            }
            return res;
    }

    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        int[] res = rearrange(arr);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(res));

    }
}
