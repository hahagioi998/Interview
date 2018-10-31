package String.RemoveAdjacent;
//这道题的难点在怎么区分字母和separator
//"I love \t\n google", there are 3 words in it.
public class CountNumberOfWords {
    public int numOfWords(String str) {
        //indicate if it's separator in front
        boolean state = false;
        int wc = 0;  // word count

        // Scan all characters one by one
        for(int i = 0; i < str.length(); i++)
        {
            // If next character is a separator, set the
            // state as OUT
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
                state = false;
                // If next character is not a word separator
                // and state is OUT, then set the state as IN
                // and increment word count
            }else if (state == false)
            {
                state = true;
                ++wc;
            }
        }
        return wc;
    }
}
