package String.Reverse;

//学会找一个词的left和right bound
public class ReverseWordsI {
    public String reverseWords(String input) {
        // Write your solution here.
        if (input == null) {
            return input;
        }
        int left = 0, right = 0;
        char[] chars = input.toCharArray();
        reverse(chars, 0, chars.length - 1);//reverse all characters, words are reversed too
        //elgooG evol I
        //找左边界和右边界
        //左边界当i - 1是空格的时候，i是左边界
        //右边界是当i+1是空格的时候，i是右边界
        for (int i = 0; i < chars.length; i++) {
            //i和
            if (chars[i] != ' ' && (i == 0 || chars[i - 1] == ' ')) {
                left = i;//find left index i of a word, also could be the first index
            }

            //i和i+1
            if (chars[i] != ' ' && (i == chars.length - 1 || chars[i + 1] == ' ')) {
                right = i;//find right index i of a word, also could be the last index
                reverse(chars, left, right);//reverse word back right after find right index
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int left, int right) {

        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
