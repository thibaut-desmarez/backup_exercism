import java.util.ArrayList;
import java.util.List;

class NaturalNumber {
    int number = 0;
    int aliquotSum = 0;
    NaturalNumber(int number) {
        this.number = number;
        this.aliquotSum = computeAliquotSum(number);
    }

    Classification getClassification() {
        if(this.number < aliquotSum){
            return Classification.ABUNDANT;
        }
        if(this.number == aliquotSum){
            return Classification.PERFECT;
        }
        else {
            return Classification.DEFICIENT;
        }
    }

    int computeAliquotSum(int number) {
        if(number <= 0){
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        if(number == 1){
            return 0;
        }
        int result = 1;
        for(int i =2; i < Math.sqrt(number);i++){
            if(number % i == 0){
                result+=i;
                result+=(number/i);
            }
        }
        return result;
    }
}
