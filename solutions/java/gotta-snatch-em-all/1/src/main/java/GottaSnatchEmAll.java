import java.util.*;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);

    }

    static boolean addCard(String card, Set<String> collection) {
        if(collection.contains(card)) {
            return false;
        }
        collection.add(card);
        return true;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if(!myCollection.isEmpty() && !theirCollection.isEmpty()) {
            Set<String> tmpMyCollection = new HashSet<>(myCollection);
            Set<String> tmpTheirCollection = new HashSet<>(theirCollection);
            myCollection.forEach(collection ->
            {
                if (theirCollection.contains(collection)) {
                    tmpMyCollection.remove(collection);
                }
            });
            theirCollection.forEach(collection ->
            {
                if (myCollection.contains(collection)) {
                    tmpTheirCollection.remove(collection);
                }
            });
            return !tmpMyCollection.isEmpty() && !tmpTheirCollection.isEmpty();
        }
        return false;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCards = new HashSet<>();
        List<String> flattenedList = collections.stream().flatMap(Collection::stream).toList();
        for (String s : collections.get(0)) {
            if(flattenedList.stream().filter(card -> card.equals(s) ).count() == collections.size()) {
                commonCards.add(s);
            }
        }
        return commonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> result = new HashSet<>();
        collections.stream()
                .flatMap(Collection::stream)
                .forEach(card -> {addCard(card, result);});
        return result;

    }
}
