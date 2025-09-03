import java.util.Arrays;

class Acronym {

    private String phrase ="";
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder acronym = new StringBuilder();
        String phraseWithoutPunctuation = phrase.replaceAll("[\\[\\]!?',;_]", "");
        String[] phraseSplited = phraseWithoutPunctuation.split("-|\\s");
        Arrays.stream(phraseSplited)
                .filter(word -> !word.isEmpty())
                .forEach(word -> acronym.append(word.substring(0,1).toUpperCase()));
        return acronym.toString();
    }

}
