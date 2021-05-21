package lesson13;

import java.math.BigDecimal;

public interface Score {

    void withdrawals(BigDecimal summa);
    void topUp(BigDecimal summa);
}
