package String;

public class MostOccuringChar {
    static final int ASCII_SIZE = 256;
    static char getMaxOccuringChar(String str)
    {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }

    public static char getMax(String word) {
        //一边计算count，一边找到最大的count
        //先++再比较
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("input word must have non-empty value.");
        }
        char maxchar = ' ';
        int maxcnt = 0;
        // if you are confident that your input will be only ascii, then this array can be size 128.
        int[] charcnt = new int[Character.MAX_VALUE + 1];
//        for (int i = word.length() - 1; i >= 0; i--) {
        for (int i =0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // increment this character's cnt and compare it to our max.
            if (++charcnt[ch] >= maxcnt) {
                maxcnt = charcnt[ch];
                maxchar = ch;
            }
        }
        return maxchar;
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str = "sample string ptp";
        System.out.println("Max occurring character is " +
                getMax(str));
    }
}
