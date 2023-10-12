package nullObjectDesignPattern;

public class Main {

    public static void main(String args[]) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("Bike");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
//        if(vehicle != null) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Fuel tank Capacity: " + vehicle.getFuelTankCapacity());
//        }
    }
// car kai alwa khuch bhi aayega toh we are getting null object.
// This Design pattern handles null pointer exception
}
