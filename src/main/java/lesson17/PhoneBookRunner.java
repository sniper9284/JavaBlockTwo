package lesson17;

import lesson17.book.Abonent;
import lesson17.book.PhoneBook;

import java.time.Duration;
import java.time.Instant;
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
        findToList(list);
        findToSet(set);
        findToMap(map);
    }

    private static void findToSet(TreeSet treeSet) {
        Instant start = Instant.now();
        TreeSet<PhoneBook> result = new TreeSet<>((o1, o2) -> 0);
        Iterator<PhoneBook> phoneBookIterator = treeSet.descendingIterator();
        while (phoneBookIterator.hasNext()) {
            PhoneBook next = phoneBookIterator.next();
            Iterator<PhoneBook> phonebookIterator2 = treeSet.descendingIterator();
            while (phonebookIterator2.hasNext()) {
                PhoneBook next2 = phonebookIterator2.next();
                if (next.equals(next2)) {
                    result.add(next2);
                }
            }
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println(result);
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static void findToMap(Map map) {
        Instant start = Instant.now();
        Iterator<Map.Entry<Abonent, Collection<Abonent>>> entryIterator =
                new TreeSet<>(map.entrySet()).descendingIterator();
        //...
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println( );
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static void findToList(LinkedList linkedList) {
        Instant start = Instant.now();
        LinkedList<PhoneBook> resultList = new LinkedList<>();
        Iterator<PhoneBook> phonebookIterator = linkedList.descendingIterator();
        while (phonebookIterator.hasNext()) {
            PhoneBook next = phonebookIterator.next();
            Iterator<PhoneBook> phonebookIterator2 = linkedList.descendingIterator();
            while (phonebookIterator2.hasNext()) {
                PhoneBook next2 = phonebookIterator2.next();
                if (next.equals(next2)) {
                    resultList.add(next2);
                }
            }
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println(resultList);
        System.out.println("Прошло времени, мс: " + elapsed);
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
