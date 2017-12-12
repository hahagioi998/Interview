package String;

public class TwoStringsAreAnagrams {
    public boolean anagram(String s, String t) {
            if(s.length() != t.length()){
        return false;
    }

    int[] count= new int[256];
        for(int i = 0; i < s.length(); i ++){
            //要注意cast to int
        count[(int)s.charAt(i)]++;
    }

    for(int i = 0; i < t.length(); i++){
        count[(int)t.charAt(i)]--;
        if(count[(int)t.charAt(i)] < 0){
            return false;
        }
    }
        return true;

}
}
