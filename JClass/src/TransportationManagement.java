abstract class Vehicle {
    protected String brand;
    protected int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    public Vehicle(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    void accelerate(int amount) {
        speed += amount;
    }
    void brake(int amount) {
        speed -= amount;
    }
    abstract void honk();
}

interface ElectricVehicle {
    abstract void chargeBattery(int amount);
    abstract void getBatteryLevel();
}

class ElectricCar extends Vehicle implements ElectricVehicle {
    private int energy = 0;

    public ElectricCar(String brand, int speed) {
        super(brand, speed);
    }
    public ElectricCar(String brand) {
        super(brand, 0);
    }

    public void chargeBattery(int amount) {
        energy += amount;
    }
    public void getBatteryLevel() {
        System.out.println("Battery level: " + energy);
    }
    public void honk() {
        System.out.println("ElectricCar:Beep Beep!");
    }
}

class Car2 extends Vehicle {
    public Car2(String brand, int speed) {
        super(brand, speed);
    }
    public Car2(String brand) {
        super(brand, 0);
    }
    @Override
    public void honk() {
        System.out.println("Car:Beep Beep!");
    }
}

class Bike extends Vehicle {
    public Bike(String brand, int speed) {
        super(brand, speed);
    }
    public Bike(String brand) {
        super(brand, 0);
    }
    @Override
    public void honk() {
        System.out.println("Bike:Ring Ring!");
    }
}

public class TransportationManagement {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car2("Nissan"), 
            new Bike("Yuntech"), 
            new ElectricCar("Xiaomi SU7")
        };
        for(Vehicle vehicle:vehicles) {
            vehicle.accelerate(80);
            vehicle.honk();
            vehicle.brake(80);
            if (vehicle instanceof ElectricCar) {
                ElectricCar electricCar = (ElectricCar) vehicle;
                electricCar.chargeBattery(50);
                electricCar.getBatteryLevel();
            }
        }
    }
     
}