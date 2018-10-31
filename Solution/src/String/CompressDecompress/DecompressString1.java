package String.CompressDecompress;
//acb2c4” → “acbbcccc
//字母的下一个可能有数字也可能没有数字
//学到怎么从string中取数字，count = Integer.valueOf(array[i + 1]+"");
//这里assume了数字不会超过9
public class DecompressString1 {
    public String decompress(String input) {
        // Write your solution here.
        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();
        for(int i = 0; i < array.length; i++){
            char c = array[i];
            //把count设为1
            int count = 1;
            //看下一个char是不是数字，不是数字的话不变
            if(i + 1 < array.length && array[i + 1] >= '0' && array[i + 1] <= '9'){//check boundary
                count = Integer.valueOf(array[i + 1]+"");//need to convert char to string, or it'll use its ASCII value
                //是数字的话i 要+1
                i++;
            }

            //也是按照count来append字母
            for(int j = 0; j < count; j++){
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}
