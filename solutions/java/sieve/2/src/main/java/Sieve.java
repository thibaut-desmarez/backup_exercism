import java.util.ArrayList;
import java.util.List;

record Sieve(int maxPrime) {

    List<Integer> getPrimes() {
        if(maxPrime < 2) return new ArrayList<>();
        List<Integer> markedPrimes = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for(int n = 3; n <= maxPrime; n+=2) {
            if(!markedPrimes.contains(n)){
                primes.add(n);
                for(int p = n*2; p <= maxPrime; p += n){
                    markedPrimes.add(p);
                }
            }
        }
        return primes;
    }
}
