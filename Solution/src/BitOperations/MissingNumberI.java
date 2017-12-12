package BitOperations;

public class MissingNumberI {
    public int missing(int[] array) {
        //  sum = (1 + n) * n / 2;
        int n = array.length + 1;
        int sum = (1 + n) * n / 2;
        int sum1 = 0;
        for (int i = 0; i < n - 1; i++) {
            sum1 += array[i];
        }
        return sum - sum1;
    }
}
