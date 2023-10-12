package strategyDesignPattern;

import strategyDesignPattern.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveObject;

    //this is known as constructor injection
    Vehicle(DriveStrategy driveObject) {
        this.driveObject = driveObject;
    }

    public void drive() {
        //some code
        driveObject.drive();
    }

//    public void drive() {
//        //some code
//        System.out.println("Normal drive capability");
//    }

}
