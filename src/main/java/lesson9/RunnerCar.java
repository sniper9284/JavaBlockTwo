package lesson9;

public class RunnerCar {

    public static void main(String[] args) throws CloneNotSupportedException {

        Car car = new Car("Audi", "AudiTT");
        Car.Driver driver = new Car.Driver();
        Car.Driver newDriver = new Car.Driver();

        car.setDrivers(driver, newDriver);

        Car anotherCar = car.clone();
        System.out.println(driver);
        System.out.println(newDriver);
        System.out.println(anotherCar);
    }
}
