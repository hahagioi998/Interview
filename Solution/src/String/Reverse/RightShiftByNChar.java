package String.Reverse;
//abcde -> edcba
//decba
//shift的题都要想到会不会超过长度
public class RightShiftByNChar {
    public String rightShift(String input, int n) {
        if (input.length() == 0) {
            return input;
        }
        //凡是n或者k就要做处理
        n %= input.length();
        char[] chars = input.toCharArray();
        //reverse全部，这样所有的letter就都shift了
        reverse(chars, 0, chars.length - 1);
        //reverse 0 到n-1和n到chars.length -1
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left <= right) {
            char c = chars[left];
            chars[left++] = chars[right];
            chars[right--] = c;
        }
    }
}
