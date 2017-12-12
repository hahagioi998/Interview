package String.Matching;

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
            StringBuilder sb = new StringBuilder();//create a count for it
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
