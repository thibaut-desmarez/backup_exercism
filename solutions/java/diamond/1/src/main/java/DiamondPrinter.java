import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char input) {
        List<String> result = new ArrayList<>();
        String letter = String.valueOf(input);
        String line = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int position = line.indexOf(letter);

        // first line if not A
        if(position != 0) {
            result.add(addFirstOrLastLine(position));
        }

        for(int i = 0; i < position; i++) { // until mid
            result.add(" ".repeat(position-1-i)+line.charAt(i+1)
                    +" ".repeat(i*2+1) // space between two letters
                    +line.charAt(i+1)+" ".repeat(position-1-i));
        }

        for(int i = position-1; i > 0;  i--) { // until the last before end
            result.add(" ".repeat(position-i)+line.charAt(i)
                    +" ".repeat((i-1)*2+1) // space between two letters
                    +line.charAt(i)+" ".repeat(position-i));
        }

        //last line
        result.add(addFirstOrLastLine(position));
        return result;
    }

    String addFirstOrLastLine(int position){
        return " ".repeat(position) + "A" + " ".repeat(position);
    }

}
