package lesson15.work;

import lombok.Getter;

@Getter
public class Employee {
    String fio;
    int workAge;

    public Employee(String fio, int workAge) {
        this.fio = fio;
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", workAge=" + workAge +
                '}';
    }
}
