package lesson14;

import lesson13.BlockedClass;
import lombok.AllArgsConstructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@AllArgsConstructor
public class PScoreInvocationHandler implements InvocationHandler {

    private PhysicalScore score;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if ("topUp".equals(method.getName()) | "withdrawals".equals(method.getName())) {
                if (method.isAnnotationPresent(Blocked.class)) {
                    BlockedClass blockedClass = new BlockedClass();
                    String str = blockedClass.stop();
                    throw new Exception(str + " изменения баланса");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method.invoke(score, args);
    }
}