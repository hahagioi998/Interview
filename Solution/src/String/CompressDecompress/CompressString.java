package String.CompressDecompress;

/*
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 */
//数数的话这i + 1 < array.length && array[i] == array[i + 1]是没问题的

//学会在一个string里数连续的数字的个数
public class CompressString {
    public String compress(String input) {
        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();
        for(int i = 0; i < array.length; i++){
            int count = 1;//count should start from 1
            char c = array[i];
            //break的时候i是最后一个重复的数字
            //数重复数字的时候用array[i] == array[i + 1]
            //这里while loop可以代替for loop和if
            while(i + 1 < array.length && array[i] == array[i + 1]){
                count++;
                i++;
            }

            //这里不能直接append，只能append string，还有就是string不能为空
            sb.append(String.valueOf(c) + (count == 1? "":String.valueOf(count)));
        }
        return sb.toString();
    }
}
