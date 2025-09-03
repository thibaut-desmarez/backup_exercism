class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int)(Math.pow(input,4)/4 + Math.pow(input,2)/4 + Math.pow(input,3)/2);
    }

    int computeSumOfSquaresTo(int input) {
        return input*(input+1)*(2*input+1)/6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
