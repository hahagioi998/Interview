package BitOperations;

//0's hex representation is "0x0"
//255's hex representation is "0xFF"
public class HexadecimalRepresentation {
    public String hex(int number) {
        //assume number > 0
        String prefix = "0x";

        if(number == 0){
            return prefix + "0";
        }

        StringBuilder sb = new StringBuilder();
        while(number > 0){
            int rem = number % 16;
            if(rem < 10){
                sb.append((char) (rem + '0'));//convert whole thing to char
            }else{
                sb.append((char) (rem - 10 + 'A'));
            }
            number >>>= 4;
        }
        return prefix + sb.reverse().toString();
    }
}
