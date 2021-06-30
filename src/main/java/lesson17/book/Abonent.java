package lesson17.book;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Data
public class Abonent {
    String fio;
    String number;
    String operator;

    public void createFio() {
        List<String> nameSet = new ArrayList<>();
        nameSet.add("Иван");
        nameSet.add("Виктор");
        nameSet.add("Сергей");
        nameSet.add("Александр");
        nameSet.add("Виталий");
        nameSet.add("Петр");
        nameSet.add("Алексей");
        nameSet.add("Евгений");
        nameSet.add("Василий");
        nameSet.add("Савелий");

        List<String> family = new ArrayList<>();
        family.add("Иванов");
        family.add("Петров");
        family.add("Сидоров");
        family.add("Скворцов");
        family.add("Цой");
        family.add("Краморов");
        family.add("Жеглов");
        family.add("Сталин");
        family.add("Кипелов");
        family.add("Кинчев");

        List<String> lastName = new ArrayList<>();
        lastName.add("Иванович");
        lastName.add("Сергеевич");
        lastName.add("Викторович");
        lastName.add("Николаевич");
        lastName.add("Александрович");
        lastName.add("Алексеевич");
        lastName.add("Евгеньевич");
        lastName.add("Олегович");
        lastName.add("Артемович");
        lastName.add("Васильевич");

        Random random = new Random();
        this.fio = family.get(random.nextInt(9)) + " "
                + nameSet.get(random.nextInt(9)) + " "
                + lastName.get(random.nextInt(9));
    }

    public void createNumber() {
        List<Integer> megafon = new ArrayList<>();
        megafon.add(928);
        megafon.add(927);
        megafon.add(938);
        megafon.add(926);
        megafon.add(937);

        List<Integer> mts = new ArrayList<>();
        mts.add(917);
        mts.add(918);
        mts.add(988);
        mts.add(989);
        mts.add(987);

        List<Integer> beeline = new ArrayList<>();
        beeline.add(902);
        beeline.add(903);
        beeline.add(905);
        beeline.add(904);
        beeline.add(906);

        Random randomNumber = new Random();
        int num = randomNumber.nextInt(9999999);
        if (randomNumber.nextInt(2) == 0) {
            this.operator = "Megafon";
            this.number = 8 + "(" + megafon.get(randomNumber.nextInt(4)) + ")" + num + " ";
        } else if (randomNumber.nextInt(2) == 1) {
            this.operator = "Mts";
            this.number = 8 + "(" + mts.get(randomNumber.nextInt(4)) + ")" + num + " ";
        } else {
            this.operator = "Beeline";
            this.number = 8 + "(" + beeline.get(randomNumber.nextInt(4)) + ")" + num + " ";
        }
    }
}
