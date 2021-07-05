package lesson17;

import lesson17.book.Abonent;
import lesson17.book.PhoneBook;

import java.util.*;

public class PhoneBookRunner {

    public static void main(String[] args) {
        LinkedList<PhoneBook> list = new LinkedList<>();
        TreeSet<PhoneBook> set = new TreeSet<>((o1, o2) -> 0);
        Map<Abonent, Collection<Abonent>> map = new TreeMap<>((o1, o2) -> 0);
        for (int i = 0; i < 1000; i++) {
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
        for (int j = 0; j < 10; j++) {
            Abonent aj = new Abonent();
            aj.createFio();
            aj.createNumber();
            bookPhone.add(aj);
        }
        return bookPhone;
    }
}
