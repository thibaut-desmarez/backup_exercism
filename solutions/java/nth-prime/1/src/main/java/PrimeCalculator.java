class PrimeCalculator {

    int nth(int nth) {
        if(nth<1) {
            throw new IllegalArgumentException();
        }
        int currentPrimeNumber = 0;
        int currentNumber = 1;
        while(currentPrimeNumber < nth) {
            currentNumber++;
            if(checkPrime(currentNumber)) {
                currentPrimeNumber++;
            }

        }
        return currentNumber;
    }

    boolean checkPrime(int number) {
        for(int i = 2 ; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
