package lesson15.work;

import java.util.List;

public class CoolEmployee {

    public static void printEmployee(List<Employee> employees, int workAge) {
        for (int i = 0; i < employees.size(); i++) {
            int z = employees.get(i).getWorkAge();
            if (workAge == z) {
                System.out.println(employees.get(i).getFio() + " работает в компании " + workAge + " лет.");
            }
        }
    }
}
