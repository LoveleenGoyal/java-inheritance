// Superclass Vehicle
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Refuelable interface
interface Refuelable {
    void refuel();
}

// Subclass ElectricVehicle extending Vehicle
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging with " + batteryCapacity + " kWh battery.");
    }
}

// Subclass PetrolVehicle extending Vehicle and implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with " + fuelCapacity + " liters of fuel.");
    }
}

// Main class to demonstrate hybrid inheritance
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle ford = new PetrolVehicle("Ford Mustang", 220, 60);

        tesla.displayInfo();
        tesla.charge();

        System.out.println();

        ford.displayInfo();
        ford.refuel();
    }
}