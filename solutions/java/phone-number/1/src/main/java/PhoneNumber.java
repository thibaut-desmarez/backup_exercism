class PhoneNumber {

    String phoneNumber;
    PhoneNumber(String numberString) {
        numberString = numberString.replaceAll("[ .()\\-+]","");
        if(numberString.matches(".*[a-zA-Z]+.*")) {throw new IllegalArgumentException("letters not permitted");}
        if(numberString.matches(".*@:!?.*")) {throw new IllegalArgumentException("punctuations not permitted");}
        if(numberString.length() < 10) {throw new IllegalArgumentException("must not be fewer than 10 digits");}
        if(numberString.length() > 11){throw new IllegalArgumentException("must not be greater than 11 digits");}
        if(numberString.length() == 11){
            if(numberString.charAt(0) != '1'){throw new IllegalArgumentException("11 digits must start with 1");}
            if(numberString.charAt(1) == '0'){throw new IllegalArgumentException("area code cannot start with zero");}
            if(numberString.charAt(1) == '1'){throw new IllegalArgumentException("area code cannot start with one");}
            if(numberString.charAt(4) == '0'){throw new IllegalArgumentException("exchange code cannot start with zero");}
            if(numberString.charAt(4) == '1'){throw new IllegalArgumentException("exchange code cannot start with one");}
            else {numberString = numberString.substring(1);}
        }
        else { //string is 10 digits
            if(numberString.charAt(0) == '0'){throw new IllegalArgumentException("area code cannot start with zero");}
            if(numberString.charAt(0) == '1'){throw new IllegalArgumentException("area code cannot start with one");}
            if(numberString.charAt(3) == '0'){throw new IllegalArgumentException("exchange code cannot start with zero");}
            if(numberString.charAt(3) == '1'){throw new IllegalArgumentException("exchange code cannot start with one");}
        }
        this.phoneNumber = numberString;
    }

    String getNumber() {
        return this.phoneNumber;
    }
}