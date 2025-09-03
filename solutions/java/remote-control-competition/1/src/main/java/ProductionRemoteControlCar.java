class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    int distanceTravelled;
    int numberOfVictories;

    public void drive() {
        this.distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        if(this.numberOfVictories > o.numberOfVictories){
            return -1;
        }
        else if(this.numberOfVictories < o.numberOfVictories){
            return 1;
        }
        return 0;
    }
}
