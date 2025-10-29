import java.util.HashMap;
import java.util.Map;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

        input = input.replace("'", "_")
                .replaceAll("[\\W\s\n,:]+", " ")
                .trim()
                .replace("_", "'");

        for (String word : input.toLowerCase().split(" ")) {
            word = word.replaceAll("^'|'$", "");

            if (word.isEmpty() || word.isBlank()) continue;

            if (! wordCountMap.containsKey(word)) {
                wordCountMap.put(word, 0);
            }

            wordCountMap.put(word, wordCountMap.get(word) + 1);
        }

        return wordCountMap;
    }
}