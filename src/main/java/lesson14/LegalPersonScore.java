package lesson14;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@Setter
public class LegalPersonScore implements Score {

    private final String name;
    private BigDecimal balance;

    public LegalPersonScore(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    @Override
    @Blocked(value = 0, name = "stop")
    public void withdrawals(BigDecimal summa) {
        this.balance = balance.subtract((BigDecimal) summa);
    }

    @Override
    @Blocked(value = 0, name = "stop")
    public void topUp(BigDecimal summa) {
        this.balance = balance.add((BigDecimal) summa);
    }

}