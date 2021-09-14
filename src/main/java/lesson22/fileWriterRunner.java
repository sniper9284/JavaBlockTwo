package lesson22;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileWriterRunner {
    public static void main(String[] args) throws IOException {
        File file = new File("e:/example/file.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("Самый классный день — это ЗАВТРА.\n Завтра мы все займемся спортом, начнем учиться, усердно работать,\n бросим пить и курить, начнем читать какую-нибудь книгу,\n перестанем жрать после шести вечера:\n Но, как не проснешься, постоянно СЕГОДНЯ!!!\n");
        writer.flush();
        writer.close();
    }
}
