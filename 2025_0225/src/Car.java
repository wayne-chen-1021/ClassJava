class Car {
    private static int totalCars = 0;
    private String brand;
    private String year;
    private float mileage = 0.00f;

    public Car(String brand, String year) {
        this.brand = brand;
        this.year = year;
        totalCars++;
    }

    public void drive(float distance) {
        mileage += distance;
    }

    public void displayInfo() {
        System.out.println("Brand:\t\t" + brand);
        System.out.println("Year:\t\t" + year);
        System.out.println("Mileage:\t" + mileage);
    }

    public static int getTotalCars() {
        return totalCars;
    }
}

class CarTestDrive {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "2018");
        car1.drive(100.12f);
        car1.displayInfo();
        Car car2 = new Car("Honda", "2020");
        car2.drive(200.12f);
        car2.displayInfo();
        System.out.println("Total cars: " + Car.getTotalCars());
    }
}
