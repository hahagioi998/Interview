package String.RemoveAdjacent;

//“aaaabbbc” is transferred to “c”
public class RemoveAdjacent3 {
    public String deDup(String input) {
        // distinguish between aabb(flag == true) and bbc(flag == false)
        if(input == null || input.length() == 0){
            return input;
        }
        int slow = 0;
        boolean flag = false;
        char[] array = input.toCharArray();

        for(int i = 1; i < array.length; i++){
            if(array[slow] == array[i]){//compare slow and fast
                flag = true;
            }else if(flag == true){  // array[slow] != array[i]
                array[slow] = array[i];//not advancing slow ptr, but overrides it
                flag = false;
            }else{
                array[++slow] = array[i];
            }
        }
        //return Arrays.copyOf(array, flag? slow : slow + 1);
        return new String(array, 0 , flag? slow : slow + 1);
    }
}
