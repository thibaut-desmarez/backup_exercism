import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Set<String> alphabet = new HashSet<String>();
        phrase = phrase.toLowerCase().replaceAll(" ","").replaceAll("-","");
        for(int i = 0; i < phrase.length(); i++) {
            String character = String.valueOf(phrase.charAt(i));
            if(!alphabet.contains(character)) {
                alphabet.add(character);
            }
            else{return false;}
        }
        return true;

    }

}
