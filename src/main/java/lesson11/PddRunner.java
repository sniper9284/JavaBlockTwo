package lesson11;

public class PddRunner extends Exception {

    public static void main(String[] args) throws CustomException {

        Car[] car = new Car[30];
        for (int i=0; i<30; i++) {
            int x = 1 + (int) (Math.random() * 2);
            if (x == 1) {
                car[i] = new PassCar();
            } else {
                car[i] = new CargoCar();
            }
        }

        for (int i=0; i < car.length; i++) {
            try {
                System.out.println("------------------------------------------------------------------------------");
                car[i].speedRun();
                car[i].overelCar();
                System.out.println("------------------------------------------------------------------------------");
            } catch (CustomException e) {
                System.out.println(e);
            }
        }
    }
}
