package lesson11;

public interface Car {
    void speedRun() throws MaxSpeed100Exception, MaxSpeed80Exception;
    void overelCar(Kpp kpp) throws WeightException, HeightException, WidthException;
}
