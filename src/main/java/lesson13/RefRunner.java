package lesson13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

public class RefRunner {

    public static void main(String[] args) throws Exception {

        //физические лица
        Class<PhysicalScore> physicalScoreClass = PhysicalScore.class;

        //смотрим какие поля, методы и конструкторы есть
        System.out.println("В классе представлены конструкторы:" + Arrays.toString(physicalScoreClass.getConstructors()));
        System.out.println("В классе представлены поля:" + Arrays.toString(physicalScoreClass.getDeclaredFields()));
        System.out.println("В классе представлены методы:" + Arrays.toString(physicalScoreClass.getDeclaredMethods()));

        try {
            //обработка конструктора
            System.out.println(" ");
            Constructor<PhysicalScore> constructor = physicalScoreClass.getConstructor(String.class);
            PhysicalScore fc = constructor.newInstance("Иванов");
            System.out.println(fc);

            //обработка поля
            System.out.println(" ");
            Field name = physicalScoreClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(fc, "Петров");
            System.out.println(fc);

            Method topUp = physicalScoreClass.getDeclaredMethod("topUp", BigDecimal.class);
            //работа с аннотацией @Blocked
            if (topUp.isAnnotationPresent(Blocked.class)) //Смотрим, есть ли у метода нужная нам Аннотация @Blocked
            {
                Blocked cmd = topUp.getAnnotation(Blocked.class);
                topUp.setAccessible(false);
                BlockedClass blockedClass = new BlockedClass();
                String str = blockedClass.stop();
                System.out.println(str + " пополнения баланса");
                System.out.println(fc);
            } else {
                topUp.setAccessible(true);
                topUp.invoke(fc, BigDecimal.valueOf(65468425));
                System.out.println(fc);
            }

            //тут запускаем метод без проверки аннотации
            Method withdrawals = physicalScoreClass.getDeclaredMethod("withdrawals", BigDecimal.class);
            withdrawals.setAccessible(true);
            withdrawals.invoke(fc, BigDecimal.valueOf(65465)); //не делаю проверку на баланс ниже 0, будем считать что это овердрафт)))
            System.out.println(fc);
            System.out.println("------------------------------------------------------------");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //юридические лица
        Class<LegalPersonScore> legalPersonScoreClass = LegalPersonScore.class;

        //смотрим какие поля, методы и конструкторы есть
        System.out.println("В классе представлены конструкторы:" + Arrays.toString(legalPersonScoreClass.getConstructors()));
        System.out.println("В классе представлены поля:" + Arrays.toString(legalPersonScoreClass.getDeclaredFields()));
        System.out.println("В классе представлены методы:" + Arrays.toString(legalPersonScoreClass.getDeclaredMethods()));

        try {
            //обработка конструктора
            System.out.println(" ");
            Constructor<LegalPersonScore> constructor = legalPersonScoreClass.getConstructor(String.class);
            LegalPersonScore lc = constructor.newInstance("ООО <<Рога и копыта>> ");
            System.out.println(lc);

            //обработка поля
            System.out.println(" ");
            Field name = legalPersonScoreClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(lc, "ООО <<Копыта и Рога>>");
            System.out.println(lc);

            Method topUp = legalPersonScoreClass.getDeclaredMethod("topUp", BigDecimal.class);
            //работа с аннотацией @Blocked
            if (topUp.isAnnotationPresent(Blocked.class)) //Смотрим, есть ли у метода нужная нам Аннотация @Blocked
            {
                Blocked cmd = topUp.getAnnotation(Blocked.class);
                topUp.setAccessible(false);
                BlockedClass blockedClass = new BlockedClass();
                String str = blockedClass.stop();
                System.out.println(str + " пополнения баланса");
                System.out.println(lc);
            } else {
                topUp.setAccessible(true);
                topUp.invoke(lc, BigDecimal.valueOf(65468425));
                System.out.println(lc);
            }

            Method withdrawals = legalPersonScoreClass.getDeclaredMethod("withdrawals", BigDecimal.class);
            withdrawals.setAccessible(true);
            withdrawals.invoke(lc, BigDecimal.valueOf(65465)); //не делаю проверку на баланс ниже 0, будем считать что это овердрафт)))
            System.out.println(lc);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
