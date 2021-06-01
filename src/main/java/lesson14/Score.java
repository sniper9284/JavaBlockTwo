package lesson14;

import java.math.BigDecimal;
public interface Score {

    @Blocked(value = 0, name = "stop")
    void withdrawals(BigDecimal summa);
    @Blocked(value = 0, name = "stop")
    void topUp(BigDecimal summa);
}
