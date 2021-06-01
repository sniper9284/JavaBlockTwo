package lesson14;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@Setter
public class PhysicalScore implements Score {

    private final String name;
    private BigDecimal balance;


    public PhysicalScore(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    @Override
    public void withdrawals(@Blocked(0) BigDecimal summa) {
        this.balance = balance.subtract((BigDecimal) summa);
    }

    @Override
    public void topUp(@Blocked(0) BigDecimal summa) {
        this.balance = balance.add((BigDecimal) summa);
    }

}