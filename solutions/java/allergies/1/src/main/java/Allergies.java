import java.util.ArrayList;
import java.util.List;

class Allergies {
    List<Allergen> allergies;
    Allergies(int score) {
        this.allergies = new ArrayList<>();
        int[] binary = new int[findPowerOfTwoMax(score)+1];
        int id = 0;
        while (score > 0) {
            binary[id++] = score % 2;
            score = score / 2;
        }
        for (int i = 0; i < Math.min(id,8); i++) {
            if(binary[i] == 1) {
                allergies.add(Allergen.values()[i]);
            }
        }
    }

    boolean isAllergicTo(Allergen allergen) {return this.allergies.contains(allergen);}
    List<Allergen> getList() {return this.allergies;}

    int findPowerOfTwoMax(int number){
        if(number == 0 || number==1) return 0;
        int iteration = 1;
        boolean end = false;
        while(!end){
            if (Math.pow(2,iteration)<=number) iteration++;
            else end = true;
        }
        return iteration;
    }
}
