package lesson11;

public class CargoCar implements Car {
    // number auto
    private int num;
    // speed auto
    private int speed;
    // weight auto
    private int weight;
    // overel auto
    private double height;
    private double length;
    private double width;

    public CargoCar() {
        this.num = 1000 + (int) (Math.random() * 1999);
        this.speed = 40 + (int) (Math.random() * 60);
        this.weight = 2 + (int) (Math.random() * 12);
        this.height = 2 + (int) (Math.random() * 5);
        this.length = 4 + (int) (Math.random() * 15);
        this.width = 0.5 + (double) (Math.random() * 3);
    }

    public int getNum() {
        return num;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void speedRun() throws MaxSpeed100Exception, MaxSpeed80Exception {
        if (getSpeed() < 80) {
            System.out.println("Авто с №" + getNum() + " движется со скоростью " + getSpeed());
        } else if (getSpeed() > 80 & getSpeed() <= 100) {
            throw new MaxSpeed80Exception("Авто с №" + getNum() + " двигается с превышением скорости, максимум 80.");
        } else if (getSpeed() > 100) {
            throw new MaxSpeed100Exception("Авто с №" + getNum() + " задержано полицией за превышение свыше 100 км/ч.");
        }
    }

    @Override
    public void overelCar(Kpp kpp) throws WeightException, HeightException, WidthException {
        if (getWeight() > kpp.getWeight()) {
            throw new WeightException("Авто с №" + getNum() + " не прошло контроль по весу.");
        } else if (getHeight() > kpp.getHeight()) {
            throw new HeightException("Авто с №" + getNum() + " не прошло контроль по высоте.");
        } else if (getWidth() > kpp.getWidth()) {
            throw new WidthException("Авто с №" + getNum() + " не прошло контроль по ширине.");
        } else {
            System.out.println("Авто с №" + getNum() + " имеет габариты (высота - " + getHeight() + " ширина - " + getWidth() + " длинна - " + getLength() + ") и весит - " + getWeight());
        }

    }
}