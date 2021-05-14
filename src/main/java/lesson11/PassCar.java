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
        this.num = num;
        this.speed = speed;
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void speedRun() {
        System.out.println("Авто с №" + getNum() + " движется со скоростью " + getSpeed());
    }

    @Override
    public void overelCar() {
        System.out.println("Авто с №" + "имеет габариты (высота - " + getHeight() + " ширина - " + getWidth() + " длинна - " + getLength() + ") и весит - " + getWeight());
    }
}
