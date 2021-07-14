package lesson21.Logger;

import lombok.Data;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
public class LogManager {
    private static final List<String> LEVEL = new ArrayList<>();
    private static String msg;
    private static String level;
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

    public void setLevel() {
        Random random = new Random();
        this.level = LEVEL.get(random.nextInt(5));
    }

    public static String getLevel() {
        return level;
    }

    @SneakyThrows
    public void writeToFile(String level, String msg) {
        Date date = new Date();
        String str = "Дата/время: " + date + ", Уровень лога: " + level + ", Сообщение: " + msg + "\r\n";
        this.outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }
}
