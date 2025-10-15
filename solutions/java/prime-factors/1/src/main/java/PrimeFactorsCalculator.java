import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator {

    List<Long> primeFactors = new ArrayList<>();

    List<Long> calculatePrimeFactorsOf(long number) {
        long counter = 3L;
        while (number % 2 == 0) {
            this.primeFactors.add(2L);
            number /= 2;
        }
        while (number > 1) {
            while (number % counter == 0) {
                this.primeFactors.add(counter);
                number /= counter;
            }
            counter += 2;
        }
        return this.primeFactors;
    }
}