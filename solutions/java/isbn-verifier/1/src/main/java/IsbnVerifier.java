class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replaceAll("-","");
        if(stringToVerify.length() != 10 || checkIfXInBadPosition(stringToVerify) || stringToVerify.replaceAll("X","").replaceAll("[0-9]","").matches("[a-zA-Z]+")) {
            return false;
        }
        int sum = 0;
        for(int i = stringToVerify.length(); i > 0 ; i--) {
            char ch = stringToVerify.charAt(stringToVerify.length()-i);
            if(ch == 'X') {
                sum += 10;
            }
            else{
                sum += Character.getNumericValue(ch)*i;
            }
        }
        return sum % 11 == 0;
    }

    boolean checkIfXInBadPosition(String stringToVerify) {
        return stringToVerify.contains("X") && !stringToVerify.endsWith("X");

    }

}
