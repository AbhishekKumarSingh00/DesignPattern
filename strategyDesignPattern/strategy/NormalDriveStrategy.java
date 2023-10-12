package strategyDesignPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        //some code
        System.out.println("Normal drive capability");
    }

}
