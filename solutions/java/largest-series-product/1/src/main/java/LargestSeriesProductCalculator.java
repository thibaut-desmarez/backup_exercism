import java.util.ArrayList;
import java.util.List;

class LargestSeriesProductCalculator {

    String inputNumber;
    LargestSeriesProductCalculator(String inputNumber) {
        if(!inputNumber.replaceAll("\\d", "").isEmpty()) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if(numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        return getResult(numberOfDigits);
    }

    private long getResult(int numberOfDigits) {
        List<String> series = new ArrayList<>();
        for (int i = 0; i < inputNumber.length()- numberOfDigits +1; i++) {
            series.add(inputNumber.substring(i, i + numberOfDigits));
        }

        long result = 0;
        long tmp = 0;
        for(String serie : series) {
            tmp=1;

            for(int j = 0; j < serie.length(); j++) {
                tmp *= Integer.parseInt(String.valueOf(serie.charAt(j)));
            }
            if(tmp > result) {
                result = tmp;
            }
        }
        return result;
    }
}
