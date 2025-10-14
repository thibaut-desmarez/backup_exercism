import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NucleotideCounter {

    String sequence;
    List<String> validLetters = List.of("A","C","G","T");
    NucleotideCounter(String sequence) {
        for(Character c : sequence.toCharArray()) {
            if(!validLetters.contains(String.valueOf(c))) {
                throw new IllegalArgumentException();
            }
        }
        this.sequence = sequence;
    }

    Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('A', 0);
        counts.put('C', 0);
        counts.put('G', 0);
        counts.put('T', 0);
        for (Character c : sequence.toCharArray()) {
            counts.put(c,counts.get(c)+1);
        }
        return counts;
    }

}