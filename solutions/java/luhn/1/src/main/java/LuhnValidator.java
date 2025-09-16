class LuhnValidator {

    boolean isValid(String candidate) {
        if(candidate == null){
            return false;
        }
        candidate = candidate.replaceAll(" ","");
        if(candidate.length() <= 1 || !candidate.matches("(\\d+)")) {
            return false;
        }

        int result = 0;
        int currentDigit = 0;
        for(int i = 0; i < candidate.length(); i++) {
            currentDigit = Character.getNumericValue(candidate.charAt(candidate.length() - 1 - i));
            if(i%2 == 0){
                result += currentDigit;
            }
            else{
                result += (currentDigit * 2)<10 ? (currentDigit*2) : (currentDigit*2)-9;
            }
        }

        return result%10 ==0;
    }

}
