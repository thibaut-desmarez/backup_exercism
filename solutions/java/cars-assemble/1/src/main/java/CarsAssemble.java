public class CarsAssemble {

    public static final int CARS_MADE_DEFAULT_SPEED = 221;
    public double productionRatePerHour(int speed) {
        if(speed >= 1 && speed <= 4) {
            return computeDefaultCarsMadeByHour(speed);
        }
        else if(speed >= 5  && speed <= 8) {
            return computeDefaultCarsMadeByHour(speed)*0.9;
        }
        else if(speed == 9 ) {
            return computeDefaultCarsMadeByHour(speed)*0.8;
        }
        else if(speed == 10) {
            return computeDefaultCarsMadeByHour(speed)*0.77;
        }
        else{
            return 0;
        }
    }

    public int workingItemsPerMinute(int speed) {
        return (int)productionRatePerHour(speed)/60;
    }

    private int computeDefaultCarsMadeByHour(int speed){
        return speed*CARS_MADE_DEFAULT_SPEED;
    }
}
