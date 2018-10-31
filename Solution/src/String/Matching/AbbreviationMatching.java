package String.Matching;
/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Examples:

pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
 */
//要么都是字母（match或者不match），要么一个字母，一个是数字
public class AbbreviationMatching {
    public boolean match(String input, String pattern) {
        // char at a position has three posibility
        // check bounds
        if(pattern.length() > input.length()){
            return false;
        }

        return match(input, pattern, 0, 0);
    }

    private boolean match(String i, String p, int pos1, int pos2) {
        if(pos1 == i.length() && pos2 == p.length()) {
            return true;
        }else if(pos1 >= i.length() || pos2 >= p.length()){
            return false;
        }

        if(i.charAt(pos1) == p.charAt(pos2)){//if current char match
            return match(i, p, pos1 + 1, pos2 + 1);
        }else if(p.charAt(pos2) >= '0' && p.charAt(pos2) <= '9'){// if it's a number
            //找到这个数字是什么，然后跳过这个数字pos1+count就可以了，数字可能有好几位
            StringBuilder sb = new StringBuilder();
            while(pos2 < p.length() && p.charAt(pos2) >= '0' && p.charAt(pos2) <= '9'){
                sb.append(p.charAt(pos2));
                pos2++;
            }

            return match(i, p, pos1 + Integer.valueOf(sb.toString()), pos2);

        }else{//if current char doesn't match
            return false;
        }
    }
}
