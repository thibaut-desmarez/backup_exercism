import java.util.HashMap;

public class PangramChecker {

    HashMap<String, Integer> letters = new HashMap<>();

    void loadAlphabet() {
        for(char ch = 'a'; ch <='z'; ++ch){
            letters.put(String.valueOf(ch),0);
        }
    }

    public boolean isPangram(String input) {
        loadAlphabet();
        input = input.toLowerCase();
        for(int i = 0; i < input.length(); ++i){
            String letter = String.valueOf(input.charAt(i));
            if(letters.containsKey(String.valueOf(letter))) {
                letters.put(String.valueOf(letter), letters.get(letter) + 1);
            }
        }
        return letters.values().stream().noneMatch(value -> value == 0);
    }

}
