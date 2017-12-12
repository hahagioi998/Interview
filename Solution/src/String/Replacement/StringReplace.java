package String.Replacement;
//input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
//        input = "dodododo", S = "dod", T = "a", input becomes "aoao"
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
            //更新fromindex到s.length
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        //最后找不到match了
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
}
