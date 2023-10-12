package nullObjectDesignPattern;

public class Car implements Vehicle {
    @Override
    public int getFuelTankCapacity() {
        return 20;
    }

    @Override
    public int getSeatingCapacity() {
        return 5;
    }
}
