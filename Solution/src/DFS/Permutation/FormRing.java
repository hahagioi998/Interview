package DFS.Permutation;

//permutation problem
public class FormRing {
    public boolean formRing(String[] input) {
        // Write your solution here.
        return helper(input, 0);
    }
    private void swap(String[] input, int left, int right) {
        String temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
    public boolean helper(String[] input, int index) {
        if (index == input.length) {
            return input[index - 1].charAt(input[index - 1].length() - 1) == input[0].charAt(0);
        }
        for (int i = index; i < input.length; i++) {
            //compare with the string in front， index is the current position， i reprents the char to try
            if (index == 0 || input[index - 1].charAt(input[index - 1].length() - 1) == input[i].charAt(0)) {
                swap(input, index, i);
                //we need to check if it's false, then continue
                if (helper(input, index + 1)) {
                    return true;
                }
                swap(input, index, i);
            }
        }
        return false;
    }
}
