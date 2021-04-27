package lesson9;

import java.util.Arrays;

public class Car implements Cloneable {

    private final String brand;
    private final String model;

    private Driver[] drivers;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void setDrivers(Driver... drivers) {
        this.drivers = drivers;
    }

    public Car clone() throws CloneNotSupportedException {
        Car newCar = (Car) super.clone();
        Driver[] newDriver = new Driver[newCar.drivers.length];
        for (int i = 0; i < newCar.drivers.length; i++) {
            newDriver[i] = newCar.drivers[i].clone();
        }
        newCar.setDrivers(newDriver);
        return newCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", drivers=" + Arrays.toString(drivers) +
                '}';
    }

    static class Driver implements Cloneable {

        public Driver clone() throws CloneNotSupportedException {
            return (Driver) super.clone();
        }
    }
}
