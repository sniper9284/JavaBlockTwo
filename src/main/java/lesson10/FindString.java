package lesson10;

import java.io.IOException;
import java.util.*;

public class FindString {

    public static void main(String[] args) throws IOException {

        Random rand = new Random();
        String[] str;
        List <String> minStrList = new ArrayList<String>();
        List <String> maxStrList = new ArrayList<String>();

        System.out.println("Введите любую строку для поиска самого короткого и самого длинного слов.");
        System.out.println("При наличае нескольких слов одинаковой длинны выведется одно - случайное.");
        str = new Scanner(System.in).nextLine().trim().split("[\\s.,?!]+");

        int minLength = str[0].length();
        int maxLength = str[0].length();
        for (String currentWord : str) {
            if (minLength > currentWord.length()) {
                minLength = currentWord.length();
                minStrList.clear();
                minStrList.add(currentWord);
            } else if (minLength == currentWord.length()) {
                minStrList.add(currentWord);
            }
            if (currentWord.length() > maxLength) {
                maxLength = currentWord.length();
                maxStrList.clear();
                maxStrList.add(currentWord);
            } else if (maxLength == currentWord.length()) {
                maxStrList.add(currentWord);
            }
        }

        System.out.println("Количество слов " + str.length);
        String randomElementMin = minStrList.get(rand.nextInt(minStrList.size()));
        System.out.println("Самое короткое слово: " + randomElementMin);
        String randomElementMax = maxStrList.get(rand.nextInt(maxStrList.size()));
        System.out.println("Самое длинное слово: " + randomElementMax);
    }
}
