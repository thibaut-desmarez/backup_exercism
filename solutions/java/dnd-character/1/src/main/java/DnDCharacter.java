import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public DnDCharacter(){
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
    }

    int ability(List<Integer> scores) {
        List<Integer> listOrdered = new ArrayList<>(scores.stream().sorted().toList());
        listOrdered.remove(0);
        return listOrdered.stream().reduce(0, Integer::sum);
    }

    List<Integer> rollDice() {
        List<Integer> scores = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 4; i++){
            scores.add(random.nextInt(1,6));
        }
        return scores;
    }

    int modifier(int input) {
        return (int) Math.floor((double) (input - 10) /2);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return 10+modifier(this.constitution);
    }
}
