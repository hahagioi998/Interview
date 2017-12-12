package BitOperations;

import java.util.HashSet;
import java.util.Set;

public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        Set<Character> set = new HashSet<>();
        for(Character c : word.toCharArray()){//type need to match
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }
}
