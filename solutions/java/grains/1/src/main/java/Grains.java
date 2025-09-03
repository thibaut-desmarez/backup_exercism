import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if(square <=0 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        BigInteger grainsOnSquare = BigInteger.TWO;
        return grainsOnSquare.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger grainsOnBoard = BigInteger.ZERO;
        for(int i =1; i<=64; i++){
            grainsOnBoard = grainsOnBoard.add(grainsOnSquare(i));
        }
        return grainsOnBoard;
    }

}
