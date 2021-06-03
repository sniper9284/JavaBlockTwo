package lesson14;

import java.lang.reflect.*;
import java.math.BigDecimal;

public class ProxyRunner {

    public static void main(String[] args) throws Exception {

        System.out.println("Работа с счетом физлиц.");
        PhysicalScore scoreF = new PhysicalScore("Jonh");
        Score proxyF = (Score) Proxy.newProxyInstance(ProxyRunner.class.getClassLoader(), new Class[]{Score.class},
                new ScoreInvocationHandler(scoreF));
        System.out.println(proxyF);
        proxyF.topUp(BigDecimal.valueOf(6548));
        proxyF.withdrawals(BigDecimal.valueOf(65468));
        System.out.println("------------------------------------------------------------");
        System.out.println("Работа с счетом юрлиц.");
        LegalPersonScore scoreL = new LegalPersonScore("OOO");
        Score proxyL = (Score) Proxy.newProxyInstance(ProxyRunner.class.getClassLoader(), new Class[]{Score.class},
                new ScoreInvocationHandler(scoreL));
        System.out.println(proxyL);
        proxyL.topUp(BigDecimal.valueOf(6548));
        proxyL.withdrawals(BigDecimal.valueOf(65468));
    }
}
