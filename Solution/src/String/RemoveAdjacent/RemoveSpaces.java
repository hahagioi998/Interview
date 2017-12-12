package String.RemoveAdjacent;
//Given a string, remove all leading/trailing/duplicated empty spaces.
public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here.
        if (input == null) {
            return input;
        }
        char[] chars = input.toCharArray();
        //slow fast pointers，left to the slow pointer is right，slow pointer not included
        int index = 0;
        //如果i-1和i都是空格，就跳过向下找，但是最后一个空格会被加上
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' && (i == 0 || chars[i - 1] == ' ')) {
                continue;
            } else {
                //先用再加，因为开头可能有空格，所以最后index会多一位
                chars[index++] = chars[i];
            }
        }

        //要看最后一位是不是空格
        if (index > 0 && chars[index - 1] == ' ') {
            return new String(chars, 0, index - 1);
        }
        return new String(chars, 0, index);
    }
}
