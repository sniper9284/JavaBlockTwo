package lesson13;

public class BlockedClass {
    @Blocked(name = "stop")
    public String stop() {
        String str = "Запрещено использовать метод";
        return str;
    }
}
