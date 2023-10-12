package strategyDesignPattern;

public class Main {

    /*
    * use Strategy design pattern when two or more child class need same code/functionality
    * but it is not in parent class
     *
     */

    public static void main(String args[]) {

        Vehicle sportVehicle = new SportVehicle();
        sportVehicle.drive();

        Vehicle passengerVehicle = new PassengerVehicle();
        passengerVehicle.drive();

        Vehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive();

    }

}
