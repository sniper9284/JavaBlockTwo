
package lesson21;

import lesson21.Logger.LogManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LoggerRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        LogManager lm = new LogManager();
        Random random = new Random();

        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                lm.setMsg(Thread.currentThread().getName());
                lm.writeToFile();
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
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
        };
        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread.start();
        thread2.start();
        thread3.start();

        Timer t = new Timer();
        TimerTask taskTimer = new TimerTask() {
            public void run() {
                thread.interrupt();
                thread2.interrupt();
                thread3.interrupt();
            }
        };
        System.out.println("Current time: " + new Date());
        t.schedule(taskTimer, 60000);
    }
}
