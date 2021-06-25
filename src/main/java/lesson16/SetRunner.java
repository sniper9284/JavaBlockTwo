package lesson16;

import lesson16.setWork.Employee;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetRunner {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
               return o1.getWorkAge().compareTo(o2.getWorkAge());
            }
        });
        employeeSet.add(new Employee("Ivanov", new BigDecimal(1)));
        employeeSet.add(new Employee("Petrov", new BigDecimal(2)));
        employeeSet.add(new Employee("Sidorov", new BigDecimal(3)));
        employeeSet.add(new Employee("Bezhan", new BigDecimal(4)));
        employeeSet.add(new Employee("Davidenko", new BigDecimal(5)));
        employeeSet.add(new Employee("Yar", new BigDecimal(6)));
        employeeSet.add(new Employee("Sirota", new BigDecimal(7)));
        employeeSet.add(new Employee("Vasilev", new BigDecimal(8)));
        employeeSet.add(new Employee("Diachenko", new BigDecimal(9)));
        employeeSet.add(new Employee("Girenko", new BigDecimal(10)));

        TreeSet<Employee> intsReverse = (TreeSet<Employee>) ((TreeSet<Employee>) employeeSet).descendingSet();

        System.out.println("Вывод по возрастанию стажа: " + employeeSet); //прямой вывод по стажу
        System.out.println("Вывод по убыванию стажа: " + intsReverse); //обратный вывод по стажу

        Random random = new Random(100);
        Set<Integer> intSet = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            intSet.add(random.nextInt(150));
        }

        Set<Integer> intSet2 = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            intSet2.add(random.nextInt(100));
        }
        print("Объединение множеств: ", union(intSet, intSet2));
        print("Пересечения множеств: ", intersact(intSet, intSet2));
    }
    // вывод на экран
    private static void print(String string, Set <Integer> set) {
        if (set.size() != 0) {
            System.out.print(string + " - ");
            for (Integer currentElement : set) {
                System.out.print(currentElement + " ");
            }
            System.out.println(".");
        }
    }

    private static Set <Integer> union(Set <Integer> set1, Set <Integer> set2) {
        Set <Integer> unionSet = new TreeSet <> ();
        for (Integer currentElement : set1) {
            unionSet.add(currentElement);
        }
        for (Integer currentElement : set2) {
            unionSet.add(currentElement);
        }
        return unionSet;
    }

    private static Set <Integer> intersact(Set <Integer> set1, Set <Integer> set2) {
        Set <Integer> intersactSet = new TreeSet <> ();
        for (Integer firstElement : set1) {
            for (Integer secondElement : set2) {
                if (firstElement == secondElement) {
                    intersactSet.add(firstElement);
                }
            }
        }
        return intersactSet;
    }
}
