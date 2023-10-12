package strategyDesignPattern;

import strategyDesignPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }

//    @Override
//    public void drive() {
//        super.drive();
//        //some code
//        System.out.println("Sport car drive capability");
//    }

}
