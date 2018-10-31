package String.Count;

//学会怎么知道两个string里的字符是不是相同
public class TwoStringsAreAnagrams {
    public boolean anagram(String s, String t) {
    if(s.length() != t.length()){
        return false;
    }

    int[] count= new int[256];
        for(int i = 0; i < s.length(); i ++){
            //要注意cast char to int
        count[(int)s.charAt(i)]++;
    }

    for(int i = 0; i < t.length(); i++){
        count[(int)t.charAt(i)]--;
        //重点在于没有对应的话会变成负数
        if(count[(int)t.charAt(i)] < 0){
            return false;
        }
    }
        return true;

}
}
