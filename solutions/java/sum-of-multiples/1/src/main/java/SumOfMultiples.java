import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    int number;
    int[] magicalItemsValue;
    SumOfMultiples(int number, int[] magicalItemsValue) {
        this.number = number;
        this.magicalItemsValue = Arrays.stream(magicalItemsValue).filter(value -> value != 0).toArray();
    }

    int getSum() {
        Set<Integer> multiples = new HashSet<>();
        for(int magicalItemValue : magicalItemsValue){
            for(int i = magicalItemValue; i < this.number; i+=magicalItemValue){
                multiples.add(i);
            }
        }
        return multiples.stream().mapToInt(Integer::intValue).sum();

    }

}
