package lesson11;

public class PassCar implements Car {
    // number auto
    int num;
    // speed auto
    int speed;
    // weight auto
    int weight;
    // overel auto
    double height;
    double length;
    double width;

    public PassCar() {
        this.num = 100 + (int) (Math.random() * 199);
        this.speed = 60 + (int) (Math.random() * 60);
        this.weight = 1 + (int) (Math.random() * 7);
        this.height = 1 + (int) (Math.random() * 3);
        this.length = 3 + (int) (Math.random() * 15);
        this.width = 0.5 + (double) (Math.random() * 1.9);
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
    public void speedRun() throws CustomException {
        if (getSpeed() < 80) {
            System.out.println("Авто с №" + getNum() + " движется со скоростью " + getSpeed());
        } else if (getSpeed() > 80 & getSpeed() <= 100) {
            throw new CustomException("Авто с №" + getNum() + " двигается с превышением скорости, максимум 80.");
        } else if (getSpeed() > 100) {
            throw new CustomException("Авто с №" + getNum() + " задержано полицией за превышение свыше 100 км/ч.");
        }
    }

    @Override
    public void overelCar() throws CustomException {
        Kpp kpp = new Kpp();
        if (getWeight() < kpp.getWeight() || getHeight() < kpp.getHeight() || getWidth() < kpp.getWidth()) {
            System.out.println("Авто с №" + getNum() + " имеет габариты (высота - " + getHeight() + " ширина - " + getWidth() + " длинна - " + getLength() + ") и весит - " + getWeight());
        } else if (getWeight() > kpp.getWeight()) {
            throw new CustomException("Авто с №" + getNum() + " не прошло контроль по весу.");
        } else if (getHeight() > kpp.getHeight()) {
            throw new CustomException("Авто с №" + getNum() + " не прошло контроль по высоте.");
        } else if (getWidth() > kpp.getWidth()) {
            throw new CustomException("Авто с №" + getNum() + " не прошло контроль по ширине.");
        }

    }
}
