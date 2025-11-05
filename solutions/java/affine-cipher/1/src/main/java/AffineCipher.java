public class AffineCipher {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public String encode(String text, int coefficient1, int coefficient2){
        if(isNotCoPrime(coefficient1,alphabet.length())){
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }
        StringBuilder result = new StringBuilder();
        text = text.replaceAll("[ ,.]","").toLowerCase();
        int counter=1;
        for(char c:  text.toCharArray()) {
            if (Character.isDigit(c)) result.append(c);
            else result.append(encryptLetter(c, coefficient1, coefficient2));
            if (counter % 5 != 0) counter++;
            else {
                result.append(" ");
                counter = 1;
            }
        }
        return result.toString().trim();
    }

    public String decode(String text, int coefficient1, int coefficient2){
        if(isNotCoPrime(coefficient1,alphabet.length())){
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }
        int mod = alphabet.length();
        int mmi = modInverse(coefficient1,mod);
        int y = 0;
        StringBuilder result = new StringBuilder();
        text = text.replaceAll(" ","");
        int decode = 0;
        for(char c:  text.toCharArray()) {
            if (Character.isDigit(c)) {result.append(c);}
            else {result.append(alphabet.charAt(Math.floorMod(mmi * (alphabet.indexOf(c)-coefficient2),mod)));}
        }
        return result.toString();
    }

    private char encryptLetter(char c, int coefficient1, int coefficient2){
        return alphabet.charAt((coefficient1 * alphabet.indexOf(c) + coefficient2) % alphabet.length());
    }

    private int gcd(int number1, int number2)
    {
        if (number1 == 0 || number2 == 0) return 0;
        if (number1 == number2) return number1;
        if (number1 > number2) return gcd(number1-number2, number2);
        return gcd(number1, number2-number1);
    }
    private boolean isNotCoPrime(int number1, int number2) {return !(gcd(number1, number2) == 1);}

    private int modInverse(int number, int modulo)
    {
        for (int x = 1; x < modulo; x++)
            if (((number % modulo) * (x % modulo)) % modulo == 1)
                return x;
        return 1;
    }
}