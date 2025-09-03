public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven(){
        return 40;
    }

    public int remainingMinutesInOven(int actualMinuts){
        return 40 - actualMinuts;
    }

    public int preparationTimeInMinutes(int layers){
        return layers*2;
    }

    public int totalTimeInMinutes(int layers, int actualMinuts){
        return preparationTimeInMinutes(layers) + actualMinuts;
    }
}
