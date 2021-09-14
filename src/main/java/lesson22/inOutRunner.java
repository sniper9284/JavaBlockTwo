package lesson22;

import java.io.*;

public class inOutRunner {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("e:/example/file.txt");
            FileReader fReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fReader);
            String line = reader.readLine();
            int nLine = 0;
            while (line != null) {
                System.out.println(line);
                File newFile = new File("e:/example/newFile" + nLine + ".txt");
                newFile.createNewFile();
                FileWriter writer = new FileWriter(newFile);
                writer.write(line);
                writer.flush();
                writer.close();
                nLine++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
