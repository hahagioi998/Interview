package BitOperations;

//assume we are using ascii encoding
// ascii encoding can encode from 0 to 255
public class AllUniqueCharactersII {
    //each int is 4 bytes, 32 bits, so we need 8 ints

    public boolean allUnique(String word) {
        int[] vec = new int[8];
        char[] array = word.toCharArray();
        for(char c : array){
            //for a value c in the range of 0 to 255
            //it's actually mapped to the int value at c/32 at index
            // and the c%32 th bit of the int value
            if((vec[c/32] >>> (c % 32) & 1) != 0){
                return false;
            }

            vec[c/32] |= 1 << (c %32);
        }

        return true;
    }

}
