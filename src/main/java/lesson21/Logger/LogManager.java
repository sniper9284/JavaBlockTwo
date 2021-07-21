package lesson21.Logger;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class LogManager extends Thread {
    private static final List<String> LEVEL = new ArrayList<>();
    private String msg;
    FileOutputStream outputStream;

    {
        try {
            outputStream = new FileOutputStream("d:/result.txt", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        LEVEL.add("INFO");
        LEVEL.add("ERROR");
        LEVEL.add("WARN");
        LEVEL.add("DEBUG");
        LEVEL.add("TRACE");
    }

    @SneakyThrows
    public void writeToFile() {
        Date date = new Date();
        Random random = new Random();
        String str = "Дата/время: " + date + ", Уровень лога: " + LEVEL.get(random.nextInt(5)) + ", Сообщение: " + msg + "\r\n";
        this.outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }
}
