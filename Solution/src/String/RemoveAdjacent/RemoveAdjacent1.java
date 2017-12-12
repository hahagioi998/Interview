package String.RemoveAdjacent;
//    “aaaabbbc” is transferred to “abc”
public class RemoveAdjacent1 {
    public String deDup(String input) {
        if(input == null || input.length() == 0){
            return input;
        }
        //left side of slow including slow is deduplicated
        int slow = 0;
        char[] array = input.toCharArray();
        for(int i = 1; i < array.length; i++){//keep at least one character
            if(array[slow] != array[i]){//
                array[++slow] = array[i];
            }
        }
        return new String(array, 0, slow + 1);//create a new string
    }
}
