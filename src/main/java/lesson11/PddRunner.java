package lesson11;

public class PddRunner extends Exception {

    public static void main(String[] args) {

        Kpp kpp = new Kpp();
        // создаем массив легковых авто
        PassCar[] passCars = new PassCar[15];
        for (int i = 0; i < 15; i++) {
            passCars[i] = new PassCar();
        }
        // создаем массив грузовиков
        CargoCar[] cargoCar = new CargoCar[15];
        for (int i = 0; i < 15; i++) {
            cargoCar[i] = new CargoCar();
        }
        int num;
        int speed;
        int weight;
        double height;
        double length;
        double width;

        // присваиваем параметры для всех авто (номер, скорость, вес и габариты)
        for (int i = 0; i < passCars.length; i++) {
            num = 100 + (int) (Math.random() * 199);
            speed = 60 + (int) (Math.random() * 60);
            weight = 1 + (int) (Math.random() * 7);
            height = 1 + (int) (Math.random() * 3);
            length = 3 + (int) (Math.random() * 15);
            width = 0.5 + (double) (Math.random() * 1.9);

            passCars[i].setNum(num);
            passCars[i].setSpeed(speed);
            passCars[i].setWeight(weight);
            passCars[i].setHeight(height);
            passCars[i].setLength(length);
            passCars[i].setWidth(width);
        }

        for (int i = 0; i < cargoCar.length; i++) {
            num = 1000 + (int) (Math.random() * 1999);
            speed = 40 + (int) (Math.random() * 60);
            weight = 2 + (int) (Math.random() * 12);
            height = 2 + (int) (Math.random() * 5);
            length = 4 + (int) (Math.random() * 15);
            width = 0.5 + (double) (Math.random() * 3);

            cargoCar[i].setNum(num);
            cargoCar[i].setSpeed(speed);
            cargoCar[i].setWeight(weight);
            cargoCar[i].setHeight(height);
            cargoCar[i].setLength(length);
            cargoCar[i].setWidth(width);
        }

        // запускаем проверку на скорость
        System.out.println("Легковые авто");
        for (int i=0; i < passCars.length; i++) {
            System.out.println("___________________________________________________________");
            try {
                String e;
                if (passCars[i].getSpeed() > 100) {
                    e = "Авто с №" + passCars[i].getNum() + " задержано полицией за превышение свыше 100 км/ч.";
                    throw new Exception(e);
                } else if (passCars[i].getSpeed() > 80 & passCars[i].getSpeed() <= 100) {
                    e = "Авто с №" + passCars[i].getNum() + " двигается с превышением скорости, максимум 80.";
                    throw new Exception(e);
                }
                passCars[i].speedRun();
                if (passCars[i].getWeight() > kpp.getWeight() || passCars[i].getWeight() > kpp.getHeight() || passCars[i].getWidth() > kpp.getWidth()) {
                    e = "Авто с №" + passCars[i].getNum() + " не проходит по габаритам.";
                    throw new Exception(e);
                }
                passCars[i].overelCar();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("___________________________________________________________");
        System.out.println("Грузовые авто");
        for (int i=0; i < cargoCar.length; i++) {
            System.out.println("___________________________________________________________");
            try {
                String e;
                if (cargoCar[i].getSpeed() > 100) {
                    e = "Авто с №" + cargoCar[i].getNum() + " задержано полицией за превышение свыше 100 км/ч.";
                    throw new Exception(e);
                } else if (cargoCar[i].getSpeed() > 80 & cargoCar[i].getSpeed() <= 100) {
                    e = "Авто с №" + cargoCar[i].getNum() + " двигается с превышением скорости, максимум 80.";
                    throw new Exception(e);
                }
                cargoCar[i].speedRun();
                if (cargoCar[i].getWeight() > kpp.getWeight() || cargoCar[i].getWeight() > kpp.getHeight() || cargoCar[i].getWidth() > kpp.getWidth()) {
                    e = "Авто с №" + cargoCar[i].getNum() + " не проходит по габаритам.";
                    throw new Exception(e);
                }
                cargoCar[i].overelCar();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
