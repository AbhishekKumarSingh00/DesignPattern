package strategyDesignPattern.strategy;

public class SportsDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        //some code
        System.out.println("Sport car drive capability");
    }

}
