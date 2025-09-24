import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Yacht {

    int[] dices;
    YachtCategory yachtCategory;
    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dices = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        if(yachtCategory == YachtCategory.YACHT) {
            if(dices[0] == dices[1] && dices[1] == dices[2] &&  dices[2] == dices[3] && dices[3] == dices[4]) {
                return 50;
            }
        }
        else if(yachtCategory == YachtCategory.ONES) {
            return returnSumOfDices(1);
        }
        else if(yachtCategory == YachtCategory.TWOS) {
            return returnSumOfDices(2);
        }
        else if(yachtCategory == YachtCategory.THREES) {
            return returnSumOfDices(3);
        }
        else if(yachtCategory == YachtCategory.FOURS) {
            return returnSumOfDices(4);
        }
        else if(yachtCategory == YachtCategory.FIVES) {
            return returnSumOfDices(5);
        }
        else if(yachtCategory == YachtCategory.SIXES) {
            return returnSumOfDices(6);
        }
        else if(yachtCategory == YachtCategory.FULL_HOUSE){
            if(returnSumOfDices(1)==3 || returnSumOfDices(2)==6 || returnSumOfDices(3)==9
                    || returnSumOfDices(4)==12 || returnSumOfDices(5)==15 || returnSumOfDices(6)== 18) {
                return Arrays.stream(dices).sum();
            }
        }
        else if(yachtCategory == YachtCategory.FOUR_OF_A_KIND){
            Map<Integer, Long> numberDices = Arrays.stream(dices)
                    .boxed()
                    .collect(Collectors.groupingBy(dice -> dice, Collectors.counting()));
            return numberDices.entrySet().stream()
                    .filter(occurrence -> occurrence.getValue() >= 4)
                    .map(entry -> 4 * entry.getKey())
                    .toList()
                    .stream().findFirst()
                    .orElse(0);
        }
        else if (yachtCategory == YachtCategory.LITTLE_STRAIGHT) {
            Map<Integer, Long> numberDices = Arrays.stream(dices)
                    .boxed()
                    .collect(Collectors.groupingBy(dice -> dice, Collectors.counting()));
            if(numberDices.size() == 5 && Arrays.stream(dices).sum() == 15) {
                return 30;
            }
        }
        else if (yachtCategory == YachtCategory.BIG_STRAIGHT) {
            Map<Integer, Long> numberDices = Arrays.stream(dices)
                    .boxed()
                    .collect(Collectors.groupingBy(dice -> dice, Collectors.counting()));
            if(numberDices.size() == 5 && Arrays.stream(dices).sum() == 20) {
                return 30;
            }
        }
        else { //CHOICE
            return Arrays.stream(dices).sum();
        }
        return 0;
    }

    int returnSumOfDices(int number){
        return Arrays.stream(dices).filter(d -> d==number).sum();
    }

}
