package String.RemoveAdjacent;
//“aaaabbbc” is transferred to “aabbc”
//注意slow的物理意义，这里应该在1的位置
public class RemoveAdjacent2 {
    public String deDup(String input) {
        if(input.length() < 2){
            return input;
        }
        //left side of slow including slow is deduped
        int slow = 1;
        char[] array = input.toCharArray();
        for(int i = 2; i < input.length(); i++){
            if(array[slow - 1] != array[i]){
                array[++slow] = array[i];
            }
        }
        return new String(array, 0, slow + 1);
    }
}
