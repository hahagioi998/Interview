package BitOperations;

//Determine the number of bits that are different for two given integers.
//5(“0101”) and 8(“1000”) has 3 different bits
//The unsigned right shift operator >>> shifts a zero into the leftmost position, while the leftmost position after >> depends on sign extension.
public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        // ^ is used for checking if bits are different
        // & is also used for counting number of bits that are 1
        a ^= b;
        int count = 0;
        while(a != 0){// while condition for bits opertation
            count += a & 1;
            a >>>= 1;//unsigned shifts
        }
        return count;
    }
}
