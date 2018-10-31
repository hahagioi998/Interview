package String.CompressDecompress;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.
 */
//又用到了在一个string数字符个数
public class CountAndSay {
    public String countAndSay(int n) {
        // StringBuilder sb = new StringBuilder();
        // sb.append("1");
        String initial = "1";
        while(n > 1){//from 1 to 21 there are two loops
            StringBuilder sb = new StringBuilder();//outside of for loop for new string
            char[] array = initial.toCharArray();

            //把整个string读完
            for(int i = 0; i < array.length; i++){//each string formed
                int count = 1;//update count inside for loop
                //同样的char用while loop来计数 T T
                //better than array[i] == array[i - 1] 这样就不会超
                while(i + 1 < array.length && array[i] == array[i + 1]){
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(array[i]));//have to convert array[i] to string
            }
            initial = sb.toString();//新的string
            n--;
        }
        return initial;
    }
}
