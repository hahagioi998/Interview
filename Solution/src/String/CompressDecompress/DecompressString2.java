package String.CompressDecompress;

//“a1c0b2c4” → “abbcccc”
public class DecompressString2 {
    public String decompress(String input) {
        // Write your solution here.
        if(input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < array.length ; i++){
            //奇数是char
            char c = array[i++];//every odd char is alphabet, use i first, then add
            //偶数是数字
            int count = array[i] - '0';// '1' - '0' = 1  every even char is number
            //然后按照count加字母
            for(int j = 0; j < count; j++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
