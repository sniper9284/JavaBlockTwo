package lesson13;

import java.math.BigDecimal;

public class ScoreRunner extends RuntimeException {

    public static void main(String[] args) {

        Score scoreF = new PhysicalScore("Jonh");
        Score scoreL = new LegalPersonScore("OOO");

        scoreF.topUp(BigDecimal.valueOf(10000000));
        scoreL.topUp(BigDecimal.valueOf(1000000000));

        System.out.println(scoreF.toString());
        System.out.println(scoreL.toString());

        scoreF.withdrawals(BigDecimal.valueOf(5000));
        scoreL.withdrawals(BigDecimal.valueOf(650000));

        System.out.println(scoreF.toString());
        System.out.println(scoreL.toString());

    }
}
