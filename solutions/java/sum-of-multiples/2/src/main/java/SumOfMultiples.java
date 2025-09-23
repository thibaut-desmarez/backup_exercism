import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

class SumOfMultiples {

    int topNumber;
    int[] magicalItemsValue;
    SumOfMultiples(int topNumber, int[] magicalItemsValue) {
        this.topNumber = topNumber;
        this.magicalItemsValue = magicalItemsValue;
    }

    int getSum() {
        return range(1,topNumber)
                .filter(number -> stream(magicalItemsValue)
                        .anyMatch(magicalItemValue -> magicalItemValue > 0 && number%magicalItemValue == 0))
                .sum();

    }

}
