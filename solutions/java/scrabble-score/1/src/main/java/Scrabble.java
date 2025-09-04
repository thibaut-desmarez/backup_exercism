import java.util.HashMap;
import java.util.List;

class Scrabble {

    HashMap<List<String>, Integer> linkedLettersPoints = populateLinkedLettersPoints();
    int score=0;
    Scrabble(String word) {
        word = word.toUpperCase();
        for(int i=0;i<word.length();i++){
            score+=findPointFromLetter(String.valueOf(word.charAt(i)));
        }
    }

    int getScore() {
        return this.score;
    }

    HashMap<List<String>, Integer> populateLinkedLettersPoints(){
        HashMap<List<String>, Integer> result = new HashMap<>();
        result.put(List.of("A","E","I","O","U","L","N","R","S","T"), 1);
        result.put(List.of("D","G"),2);
        result.put(List.of("B","C","M","P"),3);
        result.put(List.of("F","H","V","W","Y"),4);
        result.put(List.of("K"),5);
        result.put(List.of("J","X"),8);
        result.put(List.of("Q","Z"),10);
        return result;
    }

    Integer findPointFromLetter(String letter) {
        return linkedLettersPoints.get(linkedLettersPoints.keySet().stream()
                .filter(list -> list.contains(letter))
                .findFirst()
                .orElse(null));
    }
}
