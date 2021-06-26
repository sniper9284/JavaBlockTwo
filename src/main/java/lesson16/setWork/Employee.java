package lesson16.setWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Employee {
    private String fio;
    private BigDecimal workAge;
}
