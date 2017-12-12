package Array;

//have an array of numbers from 0 to n-1, one of the numbers is removed
//For example, an array of n = 6, 0 1 2 3 4 5 would become 0 1 1 2 3 5
// sum of 0 1 2 3 4 5  (0 + n - 1)* n /2 = (n - 1)*n/2
//Suppose the value a was removed and replaced by b. Now the sum of the modified vector will be N(N-1)/2 + b - a
//If we subtract the sum of the modified vector from N(N-1)/2 we get a - b. So A = a - b.

//Similarly, the sum of the squares of the original vector is N(N-1)(2N-1)/6.
// The sum of the squares of the modified vector is N(N-1)(2N-1)/6 + b^2 - a^2.
// Subtracting the sum of the squares of the modified vector from the original sum gives a2 - b2, which is the same as (a+b)(a-b).
// So if we divide it by a - b (i.e., A), we get B = a + b.
//Now B + A = a + b + a - b = 2a and B - A = a + b - (a - b) = 2b.

//1^2 + 2^2 + 3^2 + .. n^2 = n(n+1)(2n+1)/6
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that
//at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
// n = 6 , 1 2 3 4 5 6 1  so i is from 1 to n, size is n + 1 so index is from 0 to n
public class FindDup {
    //O(n) time and O(n) space
    public int findDup(int[] number){
        boolean[] array = new boolean[number.length];
        for(int i : number){ // i is from 0 to n - 1
            if(!array[i]){
                array[i] = true;  // index in array is from 0 to n - 1
            }else{
                return i;
            }
        }

        return -1;

        //O(n) time and O(1) space

    }

    public static void main(String args[]) {

        FindDup p = new FindDup();
        int res = p.findDup(new int[]{1, 5, 3, 6, 4, 2, 3});
        System.out.println(res);
    }
}
