package lesson13;

import java.math.BigDecimal;

public class LegalPersonScore implements Score {

    private final String name;
    private BigDecimal balance;
    private BigDecimal summa;

    public LegalPersonScore(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    @Override
    @Blocked(name = "stop")
    public void withdrawals(BigDecimal summa) {
        this.balance = balance.subtract((BigDecimal) summa);
    }

    @Override
    @Blocked(name = "stop")
    public void topUp(BigDecimal summa) {
        this.balance = balance.add((BigDecimal) summa);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LegalPersonScore{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
