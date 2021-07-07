package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите предложение для сортировки.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//получаем строку от пользователя
        String userString = reader.readLine();
        Stream.of(userString.split("[^A-Za-zА-Яа-я]+"))
                .map(String::toLowerCase)
                .distinct().sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().
                sorted(Map.Entry.comparingByKey())
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                        .reversed())
                .map(n -> n.getKey())
                .forEach(System.out::println);
    }
}
