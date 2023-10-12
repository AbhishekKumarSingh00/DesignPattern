package strategyDesignPattern;

import strategyDesignPattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
    //it has normal drive capability
}
