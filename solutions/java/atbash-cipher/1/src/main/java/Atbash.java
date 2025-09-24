import java.util.ArrayList;

class Atbash {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String reverseAlphabet = "zyxwvutsrqponmlkjihgfedcba";

    String encode(String input) {
        String text = "";
        input = input.replaceAll(" ","").replaceAll("[,?.]", "").toLowerCase();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                text +=  reverseAlphabet.charAt(alphabet.indexOf(input.charAt(i)));
            }
            else{
                text += input.charAt(i);
            }
            if(i%5==4 && i!= input.length()-1){
                text += " ";
            }
        }
        return text;
    }

    String decode(String input) {
        String text = "";
        input = input.replaceAll(" ","").replaceAll("[,?.]", "").toLowerCase();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                text +=  alphabet.charAt(reverseAlphabet.indexOf(input.charAt(i)));
            }
            else{
                text += input.charAt(i);
            }
        }
        return text;
    }

}
