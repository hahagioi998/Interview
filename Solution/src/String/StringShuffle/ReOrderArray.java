package String.StringShuffle;
/*
Given an array of elements, reorder it as follow:

        { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

        { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
1 4 5 2 3 6

{ 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
{ 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
 1 5 6 7 2 3 4 8
 1 5 2 3 6 7 4 8

*/
//处理奇数偶数穿插的问题 %2
public class ReOrderArray {
    public int[] reorder(int[] array) {
        if(array.length % 2 == 0){
            reorder(array, 0, array.length - 1);
        }else{
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right){
        int length = right - left + 1;
        //if the subarray has 2 or 0 elements, it's base case, just return
        if(length <= 2){
            return;
        }
    }

    private void reverse(char[] chars, int left, int right) {
        while (left <= right) {
            char c = chars[left];
            chars[left++] = chars[right];
            chars[right--] = c;
        }
    }
}
