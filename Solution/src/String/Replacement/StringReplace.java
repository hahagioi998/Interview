package String.Replacement;
//input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
//        input = "dodododo", S = "dod", T = "a", input becomes "aoao"
//学会在一个string里match另一个string，要会用indexOf来找到左右边界
public class StringReplace {
    public String replace(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        //we check if there exists a substring same as s
        // in the substring of input starting at fromIndex
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);

        while(matchIndex != -1){
            //fromIndex到 matchIndex是前一段，然后加上t
            sb.append(input, fromIndex, matchIndex).append(t);
            //更新fromindex到s.length，找到右边
            fromIndex = matchIndex + s.length();
            //找到下一个match的左边界
            matchIndex = input.indexOf(s, fromIndex);
        }
        //最后找不到match了，fromIndex是起点，input.length()是end
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
}
