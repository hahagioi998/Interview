package String.Reverse;

public class ReverseString {
    public String reverse(String input) {
        //need to know how to do it in a recursive way
        if(input.length() == 0){
            return input;
        }

        //int left = 0, right = input.length() - 1;
        char[] array = input.toCharArray();

        for(int left = 0, right = input.length() - 1; left < right; left ++, right --){
            swap(array, left, right);
        }
        return new String(array);//new string
    }

    private void swap(char[] array, int left, int right){//left and right are char
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    //recursion的方法
//    public String revesrse(String input) {
//        if (input.length() == 0) {
//            return input;
//        }
//
//        //int left = 0, right = input.length() - 1;
//        char[] array = input.toCharArray();
//        helper(array, 0, array.length - 1);
//        return new String(array);
//    }
//
//    private void helper(char[] array, int left, int right){
//        if(left >= right){
//            return;
//        }
//
//        swap(array, left, right);
//        helper(array, left + 1, right - 1);
//    }
}
