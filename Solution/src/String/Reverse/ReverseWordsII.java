package String.Reverse;
//不仅要reverse还要去掉多余的空格
public class ReverseWordsII {
    public String reverseWords(String input) {
        // Write your solution here.
        char[] array = input.toCharArray();
        int slow = 0;
        //先去掉开头的空格，
        for(int i = 0; i < array.length; i++){
            //leading 0, consecutive 0, what about traing zero?
            // while((i == 0 || array[i - 1] ==  ' ') && array[i] == ' '){
            // i++;
            // }
            //trailing zeros will lead to outofbound error, so need to check
            // the bound of i using if instead of while
            if((i == 0 || array[i - 1] ==  ' ') && array[i] == ' '){
                continue;
            }
            array[slow++] = array[i];
        }

        //看最后一位是不是空格
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }

        //得到一个空格是对的新的string
        String newString = new String(array, 0 , slow);//slow is count
        char[] newArray = newString.toCharArray();

        //按照reverseI来做
        reverse(newArray, 0, slow - 1);

        int left = 0, right = 0;
        for(int i = 0; i < slow; i++){
            //
            if((i == 0 || newArray[i - 1] ==' ') && newArray[i] != ' '){
                left = i;
            }

            if((i == slow - 1 ||  newArray[i + 1] == ' ') && newArray[i] != ' '){
                right = i;
                reverse(newArray, left, right);
            }
        }
        return new String(newArray);
    }

    private void reverse(char[] array, int left, int right){
        while(left < right){
            char temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
    }
}
