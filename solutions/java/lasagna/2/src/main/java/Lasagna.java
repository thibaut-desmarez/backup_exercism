public class Lasagna {
    public int expectedMinutesInOven(){
        return 40;
    }

    public int remainingMinutesInOven(int actualMinuts){
        return expectedMinutesInOven() - actualMinuts;
    }

    public int preparationTimeInMinutes(int layers){
        return layers*2;
    }

    public int totalTimeInMinutes(int layers, int actualMinuts){
        return preparationTimeInMinutes(layers) + actualMinuts;
    }
}
