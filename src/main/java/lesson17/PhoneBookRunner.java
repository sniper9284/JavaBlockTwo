package lesson17;

import lesson17.book.Abonent;
import lesson17.book.PhoneBook;
import java.util.*;

public class PhoneBookRunner {

    public static void main(String[] args) {
        List<PhoneBook> list = new ArrayList<>();
        Set<PhoneBook> set = new HashSet<>();
        Map<Abonent, Collection<Abonent>> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            PhoneBook phoneBooksi = new PhoneBook(createOwnerAbonent(new Abonent()), createContacts(new ArrayList<>()));
            list.add(phoneBooksi);
            set.add(phoneBooksi);
            map.put(phoneBooksi.getAbonent(), phoneBooksi.getContacts());
        }
    }

    private static Abonent createOwnerAbonent(Abonent ownerAbonent) {
        ownerAbonent.createFio();
        ownerAbonent.createNumber();
        return ownerAbonent;
    }

    private static Collection<Abonent> createContacts(Collection<Abonent> bookPhone) {
        for (int j = 0; j < 100; j++) {
            Abonent aj = new Abonent();
            aj.createFio();
            aj.createNumber();
            bookPhone.add(aj);
        }
        return bookPhone;
    }
}
