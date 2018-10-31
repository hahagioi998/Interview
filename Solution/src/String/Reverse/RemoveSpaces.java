package String.Reverse;
//Given a string, remove all leading/trailing/duplicated empty spaces.
//必会的除空格题，要处理第一个是空格和前面都是空格，也是快慢指针题，用index++
public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here.
        if (input == null) {
            return input;
        }
        char[] chars = input.toCharArray();
        //slow fast pointers，left to the slow pointer is right，slow pointer not included
        int index = 0;
        //如果i-1和i都是空格，就跳过向下找，但是最后一个空格不能除去
        for (int i = 0; i < chars.length; i++) {
            //要考虑只有chars[i]是一个空格和前面有多个空格
            //但是如果最后有一个空格，前面不是空格，就会被加到index里
            if (chars[i] == ' ' && (i == 0 || chars[i - 1] == ' ')) {
                continue;
            } else {
                //知道chars[i]不是空格了
                //先用再加
                chars[index++] = chars[i];
            }
        }

        //要看最后一位是不是空格,用index
        if (index > 0 && chars[index - 1] == ' ') {
            return new String(chars, 0, index - 1);
        }
        return new String(chars, 0, index);
    }
}
