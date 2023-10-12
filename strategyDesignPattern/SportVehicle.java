package strategyDesignPattern;

import strategyDesignPattern.strategy.SportsDriveStrategy;

public class SportVehicle extends Vehicle {

    SportVehicle() {
        super(new SportsDriveStrategy());
    }

//    @Override
//    public void drive() {
//        super.drive();
//        //some code
//        System.out.println("Sport car drive capability");
//    }
}
