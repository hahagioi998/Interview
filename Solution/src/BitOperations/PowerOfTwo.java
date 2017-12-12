package BitOperations;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        //power of 2 must be 100 or 10 or 1
        // number & (number - 1) will cancel each other
        //& is used for checking if bit is 1
        if(number > 0 && (number & (number - 1)) == 0){ //number has to be positive
            return true;
        }
        return false;


//        Method2
//        if(number < 0){
//            return false;
//        }
//
//        while((number & 1) ==0 ){ ignore all trailing 0s
//            number >>>= 1;
//        }
//
//        return number == 1;
    }
}
