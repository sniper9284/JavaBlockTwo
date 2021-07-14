package lesson21;

import lesson21.Logger.LogManager;
import java.io.*;
import java.util.Random;

public class LoggerRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        LogManager lm = new LogManager();

        Random random = new Random();
        for (int i = 60; i > 0; i--) {
            new Thread(() -> {
                Thread.currentThread().setName("Поток 1");
                lm.setLevel();
                lm.writeToFile(lm.getLevel(), Thread.currentThread().getName());
                try {

                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                Thread.currentThread().setName("Поток 2");
                lm.setLevel();
                lm.writeToFile(lm.getLevel(), Thread.currentThread().getName());
                try {

                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                Thread.currentThread().setName("Поток 3");
                lm.setLevel();
                lm.writeToFile(lm.getLevel(), Thread.currentThread().getName());
                try {

                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);
        }
        String inputFileName = "d:/result.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
