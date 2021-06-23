package lesson15;

import lesson15.work.CoolEmployee;
import lesson15.work.Employee;

import java.util.*;

public class CoolRunner {

    public static void main(String[] args) {
        Employee ivanov = new Employee("Ivanov", 1);
        Employee petrov = new Employee("Petrov", 2);
        Employee sidorov = new Employee("Sidorov", 3);
        Employee bezhan = new Employee("Bezhan", 4);
        Employee davidenko = new Employee("Davidenko", 5);
        Employee yar = new Employee("Yar", 6);
        Employee sirota = new Employee("Sirota", 7);
        Employee vasilev = new Employee("Vasilev", 8);
        Employee diachenko = new Employee("Diachenko", 9);
        Employee girenko = new Employee("Girenko", 10);

        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(ivanov);
        employeesList.add(petrov);
        employeesList.add(sidorov);
        employeesList.add(bezhan);
        employeesList.add(davidenko);
        employeesList.add(yar);
        employeesList.add(sirota);
        employeesList.add(vasilev);
        employeesList.add(diachenko);
        employeesList.add(girenko);

        //вывод массива в принципе
        System.out.println(employeesList.toString());

        //рандом для определения стажа.
        Random rand = new Random();
        int min = 0;
        int max = 10;
        int x = min + rand.nextInt(max - min + 1);

        //вывод имени при совпадении стажа работы
        CoolEmployee coolEmployee = new CoolEmployee();
        coolEmployee.printEmployee(employeesList, x);

        //удаление всех нечетных записей двигаясь с конца
        boolean odd = false;
        for (ListIterator iterator = employeesList.listIterator(employeesList.size()); iterator.hasPrevious(); odd = !odd) {
            iterator.previous();
            if (odd) {
                iterator.remove();
            }
        }
        System.out.println(employeesList);
    }
}
