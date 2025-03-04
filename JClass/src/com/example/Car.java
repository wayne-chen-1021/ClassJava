package com.example;
public class Car {
    private static int totalCars = 0;
    private String brand;
    private int year;
    private int mileage = 0;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
        totalCars++;
    }

    public void drive(int distance) {
        if (distance >= 0)  mileage += distance;
        else System.out.println("行駛距離有誤");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
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

class CarTestDrive { //2025 0225課堂練習
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 2018);
        System.out.println(car1.getBrand() + car1.getYear());
        car1.drive(100);

        Car car2 = new Car("Honda", 2020);
        System.out.println(car2.getBrand() + car2.getYear());
        car2.drive(200);

        System.out.println("Total cars: " + Car.getTotalCars());
    }
}
