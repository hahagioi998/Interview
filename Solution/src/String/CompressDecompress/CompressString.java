package String.CompressDecompress;

//数数的话这i + 1 < array.length && array[i] == array[i + 1]是没问题的
public class CompressString {
    public String compress(String input) {
        // write your solution here
        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();
        for(int i = 0; i < array.length; i++){
            int count = 1;//count should start from 1
            char c = array[i];
            //break的时候i是最后一个重复的数字
            //数重复数字的时候用array[i] == array[i + 1]
            while(i + 1 < array.length && array[i] == array[i + 1]){
                count++;
                i++;
            }

            sb.append(String.valueOf(c) + (count == 1? "":String.valueOf(count)));
        }
        return sb.toString();
    }
}
