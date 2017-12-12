package BinarySearch;
/*
Input: arr[]  = {2, 4, 8, 10, 12, 14}
Output: 6

Input: arr[]  = {1, 6, 11, 16, 21, 31};
Output: 26
A Simple Solution is to linearly traverse the array and find the missing number. Time complexity of this solution is O(n).

We can solve this problem in O(Logn) time using Binary Search. The idea is to go to the middle element.
Check if the difference between middle and next to middle is equal to diff or not, if not then the missing element lies between mid and mid+1.
If the middle element is equal to n/2th term in Arithmetic Series (Let n be the number of elements in input array), then missing element lies in right half.
Else element lies in left half.
 */
public class BinarySearchInArithmeticProgression {
    public int search(int input[]){
        int low =0;
        int high = input.length-1;
        //找到间隔
        int ap = (input[high] - input[low])/(input.length);
        int middle = -1;

        while(low <= high){
            middle = (low + high)/2;

            if(input[middle] == input[0] + (middle)*ap){
                //说明前半段是对的，缺的应该在后半段
                low = middle + 1;
            }else if((input[middle] > input[0] + (middle)*ap) && input[middle - 1] == input[0] + (middle - 1)* ap){
                //说明前半段缺，但是mid-1这个位置上是对的，那就说明错的是mid这个位置上的
                return input[0] + (middle)*ap;
            }else{
                //如果前半段缺了，那input[middle]会更大
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int input[] = {1,7,10,13,16,19,22};
        BinarySearchInArithmeticProgression aps = new BinarySearchInArithmeticProgression();
        System.out.println(aps.search(input));
    }
}
