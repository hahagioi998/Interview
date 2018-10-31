package String.RemoveAdjacent;

//"abbbaaccz" → "aaaccz" → "ccz" → "z"
//"aabccdc" → "bccdc" → "bdc"
//学会利用slow的前进和后退来消掉重复的字符
public class RemoveAdjacent4 {
    public String deDup(String input) {
        // 分相等和不等，不等的话++slow = fast，相等的话就 slow--，然后dedup fast
        if (input == null || input.length() < 2) {
            return input;
        }
        int slow = 0;
        char[] chars = input.toCharArray();

        for (int i = 1; i < chars.length; i++) {//fast
            if (slow == -1 || chars[i] != chars[slow]) {//slow could be -1
                //不同的时候slow前进了
                chars[++slow] = chars[i];
            } else {
                //如果是相等的就说明slow是也是重复的
                //这里很重要，slow后退因为还不能确定之前的slow的位置上是不是可以保留
                slow--;//dedecrement slow
                while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                    //check i + 1 to make sure it doesn't go out of bound
                    i++;
                    //如果是2,2,2结尾那么就会停在最后的一个2上
                    //如果2，2，3那么就会停在3上
                }
            }
        }
        return new String(chars, 0, slow + 1);
    }
}
