class Bob {

    String hey(String input) {
        input = input.trim();
        if (isSilence(input)) return "Fine. Be that way!";
        if(isQuestion(input)){
            if(isYelling(input))return "Calm down, I know what I'm doing!";
            else return "Sure.";
        }
        if(isYelling(input))return "Whoa, chill out!";
        return "Whatever.";
    }

    boolean isSilence(String phrase) {return phrase.isBlank();}
    boolean isQuestion(String phrase) {return phrase.endsWith("?");}
    boolean isYelling(String phrase) { return phrase.chars().anyMatch(Character::isLetter) && phrase.equals(phrase.toUpperCase());}
}