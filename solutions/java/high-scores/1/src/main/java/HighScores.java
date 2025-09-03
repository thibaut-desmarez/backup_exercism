import java.util.ArrayList;
import java.util.List;

class HighScores {

    private List<Integer> highScores;
    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return this.highScores;
    }

    Integer latest() {
        return scores().get(scores().size() - 1);
    }

    Integer personalBest() {
        return scores().stream().sorted().toList().get(scores().size() - 1);
    }

    List<Integer> personalTopThree() {
        List<Integer> scoresSorted = scores().stream().sorted().toList();
        List<Integer> result = new ArrayList<>();
        result.add(scoresSorted.get(scores().size() - 1));
        if(scoresSorted.size() >= 2) {
            result.add(scoresSorted.get(scores().size() - 2));
        };

        if(scoresSorted.size() >= 3) {
            result.add(scoresSorted.get(scores().size() - 3));
        };

        return result;
    }

}
