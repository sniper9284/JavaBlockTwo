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
        Map<Abonent, Collection<Abonent>> map = new HashMap<>();
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
        List<PhoneBook> phoneBookList = new ArrayList<>();
        phoneBookList.add((PhoneBook) treeSet.descendingIterator().next());
        phoneBookList.retainAll(treeSet);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println(phoneBookList);
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static void findToMap(Map map) {
        Iterator<Map.Entry<Abonent, Collection<Abonent>>> entryIterator =
                new TreeSet<>(map.entrySet()).descendingIterator();
            //понять как быть дальше
    }

    private static void findToList(LinkedList linkedList) {
        Instant start = Instant.now();
        List<PhoneBook> resultList = new ArrayList<>();
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
