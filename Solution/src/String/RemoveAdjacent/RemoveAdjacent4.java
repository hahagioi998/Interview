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

    public String removeTriplet(String s) {
        //Resetting counter at i=0 is very important at step 2 because there may be the case that previous i-2 and i-1 characters are same as i+3 characters so we should start checking triplets from two places before the current position of the string.
        int start = 0;

        StringBuilder input = new StringBuilder(s);
        while (start < input.length() - 2) {
            if (input.charAt(start) == input.charAt(start + 1)
                && input.charAt(start) == input.charAt(start + 2)) {

                while(start + 1 < input.length() && input.charAt(start) == input.charAt(start + 1)){
                    input.deleteCharAt(start);
                }
                input.deleteCharAt(start);
                //删掉重复的以后，需要看一下start和前面的两个是不是又组成了三个
                //reset start
                start = (start - 2) > 0 ? (start - 2) : 0;
            } else {
                start++;
            }

        }
        return input.toString();
    }

    //不是好方法
    public String removeTripletArray(String s) {
        //Resetting counter at i=0 is very important at step 2 because there may be the case that previous i-2 and i-1 characters are same as i+3 characters so we should start checking triplets from two places before the current position of the string.
        int start = 0;

        char[] array = s.toCharArray();
        while (start < array.length - 2) {
            if (array[start] == array[start + 1]
                && array[start] == array[start + 2]) {
//                input.deleteCharAt(start);
//                input.deleteCharAt(start);
//                input.deleteCharAt(start);
                int i = start;
                while(start + 1 < array.length &&  array[i] ==  array[i + 1]){
                    i++;
                }
                array[start] = array[i];
                //删掉重复的以后，需要看一下start和前面的两个是不是又组成了三个
                //reset start
                start = (start - 2) > 0 ? (start - 2) : 0;
            } else {
                start++;
            }

        }
        return new String(array);
    }

//    public int[][] candyCrush(String input) {
//        int n = input.length();
//
//        boolean shouldContinue = false;
//        char[] board = input.toCharArray();
//        // Crush horizontally
//            for (int j = 0; j < n - 2; j++) {
//                int v = Math.abs(board[j]);
//                if (v > 0 && v == Math.abs(board[j + 1]) && v == Math.abs(board[j + 2])) {
//                    board[j] = board[j + 1] = board[j + 2] = -v;
//                    shouldContinue = true;
//                }
//            }
//
//        return shouldContinue ? candyCrush(board) : board;
//
//    }

    public static void main(String[] args){
        RemoveAdjacent4 removeAdjacent4 = new RemoveAdjacent4();
//        System.out.println(removeAdjacent4.removeTriplet("wwwrrddrrdd"));
//        System.out.println(removeAdjacent4.removeTriplet("aabbbaccddddc"));
        System.out.println(removeAdjacent4.removeTripletArray("wwwrrddrrdd"));
        System.out.println(removeAdjacent4.removeTripletArray("aabbbaccddddc"));
    }
}
