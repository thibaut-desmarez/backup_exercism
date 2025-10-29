public class SquareRoot {
    public int squareRoot(int radicand) {
        boolean found = false; int start = 1;
        while(!found){
            if(start*start == radicand) found = true;
            else{start++;}
        }
        return start;
    }
}
