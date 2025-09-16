record RotationalCipher(int shiftKey) {

    String rotate(String data) {
        if(shiftKey == 0 || shiftKey == 26) {
            return data;
        }
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabetCapital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < data.length(); i++) {
            if(alphabet.contains(String.valueOf(data.charAt(i)))) { //lowercase
                result.append(alphabet.charAt((alphabet.indexOf(data.charAt(i)) + shiftKey) % 26));
            }
            else if(alphabetCapital.contains(String.valueOf(data.charAt(i)))){ //uppercase
                result.append(alphabetCapital.charAt((alphabetCapital.indexOf(data.charAt(i)) + shiftKey) % 26));
            }
            else{ //other character
                result.append(data.charAt(i));
            }
        }
        return result.toString();
    }
}