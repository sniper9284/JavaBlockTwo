package lesson11;

public interface Car {
    void speedRun() throws MaxSpeed100Exception, MaxSpeed80Exception;
    void overelCar() throws WeightException, HeightException, WidthException;
}
