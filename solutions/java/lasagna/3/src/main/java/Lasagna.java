public class Lasagna {

    private static final int EXPECTED_MINUTES_IN_OVEN = 40;
    private static final int PREPARATION_TIME_PER_LAYER = 2;
    
    public int expectedMinutesInOven(){
        return EXPECTED_MINUTES_IN_OVEN;
    }

    public int remainingMinutesInOven(int actualMinuts){
        return expectedMinutesInOven() - actualMinuts;
    }

    public int preparationTimeInMinutes(int layers){
        return layers*PREPARATION_TIME_PER_LAYER;
    }

    public int totalTimeInMinutes(int layers, int actualMinuts){
        return preparationTimeInMinutes(layers) + actualMinuts;
    }
}
