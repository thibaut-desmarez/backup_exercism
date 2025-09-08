import java.util.ArrayList;
import java.util.List;

class HandshakeCalculator {
    List<Signal> calculateHandshake(int number) {
        number = number%32;
        int[] binary = convertIntToBinary(number);
        List<Signal> signals = new ArrayList<>();
        if(binary[4]==1){ //reverse
            if(binary[3]==1) signals.add(Signal.JUMP);
            if(binary[2]==1) signals.add(Signal.CLOSE_YOUR_EYES);
            if(binary[1]==1) signals.add(Signal.DOUBLE_BLINK);
            if(binary[0]==1) signals.add(Signal.WINK);
        }
        else{
            if(binary[0]==1) signals.add(Signal.WINK);
            if(binary[1]==1) signals.add(Signal.DOUBLE_BLINK);
            if(binary[2]==1) signals.add(Signal.CLOSE_YOUR_EYES);
            if(binary[3]==1) signals.add(Signal.JUMP);
        }
        return signals;
    }

    int[] convertIntToBinary(int number) {
        int[] binary = new int[5];
        int id = 0;
        String result = "";

        while (number > 0) {
            binary[id++] = number % 2;
            number = number / 2;
        }
        return binary;
    }
}
