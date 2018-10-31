package String.Reverse;

//相向而行，同时是vowel才换
public class ReverseOnlyVowels {
    public String reverse(String input) {
        // Write your solution here.
        String str = "aeoiu";//string api contains
        int left = 0;
        int right = input.length() - 1;
        char[] array = input.toCharArray();
        while(left < right){
            while(left < right && !str.contains(array[left]+"")){//str.contains must convert char to string
                left++;
            }
            while(left < right && !str.contains(array[right]+"")){
                right--;
            }
            swap(array, left, right);
            left++;
            right--;
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
