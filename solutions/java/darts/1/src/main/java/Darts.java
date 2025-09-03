import static java.lang.Math.pow;

class Darts {
    int score(double xOfDart, double yOfDart) {
        double sumOfSquareXandY = pow(xOfDart, 2) + pow(yOfDart, 2);
        return sumOfSquareXandY <= 1 ? 10 : sumOfSquareXandY <= 25 ? 5 : sumOfSquareXandY <= 100 ? 1 : 0;
    }
}
