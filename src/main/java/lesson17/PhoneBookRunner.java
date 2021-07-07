package lesson17;

import lesson17.book.Abonent;
import lesson17.book.PhoneBook;

import javax.swing.text.html.parser.Entity;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class PhoneBookRunner {

    public static void main(String[] args) {
        LinkedList<Abonent> abonentlist = new LinkedList<>();
        List<PhoneBook> phoneBookResult = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Abonent abonent = new Abonent();
            createAbonent(abonent);
            abonentlist.add(abonent);
        }
        for (int i = 0; i < 1000; i++) {
            PhoneBook phone = new PhoneBook();
            phone.setAbonent(abonentlist.get(i));
            phone.setContacts(createContacts(abonentlist));
            phoneBookResult.add(phone);
        }
        findToSet(phoneBookResult);
        findToList(phoneBookResult);
        findToMap(phoneBookResult);
        findToArray(phoneBookResult);
    }
    //сравнивает только одну запись. Разобраться какого хрена так.
    private static void findToArray(List<PhoneBook> result) {
        Instant start = Instant.now();
        List<Object> find = new ArrayList<>();
        List<Object> res = new ArrayList<>();
        List<Object> res2 = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            find.add(result.get(i).getContacts());
        }
        Object[] resArray = find.toArray();
        System.out.println(resArray[0].toString());
        res.add(resArray[0]);
        for (int i = 1; i < resArray.length; i++) {
            res2.add(resArray[i]);
            res.removeAll(res2);
        }
        System.out.println("--------------");
        System.out.println(res);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static void findToMap(List<PhoneBook> result) {
        Instant start = Instant.now();
        List<Object> res = new ArrayList<>();
        List<Object> one = new ArrayList<>();
        List<Object> two = new ArrayList<>();
        Map<Abonent, Collection<Abonent>> resultMap = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            resultMap.put(result.get(i).getAbonent(), result.get(i).getContacts());
        }
        Iterator itr = resultMap.entrySet().iterator();
            Map.Entry entryOne = (Map.Entry) itr.next();
            one.add(entryOne.getValue());
        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            two.add(entry.getValue());
        }
        one.retainAll(two);
        res.add(two);
        System.out.println("--------------");
        System.out.println(res);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static void findToList(List<PhoneBook> result) {
        Instant start = Instant.now();
        LinkedList<Collection> commonContacts = new LinkedList<>();
        for (int k1 = 0; k1 < result.size(); k1++) {
            PhoneBook p1 = result.get(k1);
            for (int k2 = k1 + 1; k2 < result.size() - k1; k2++) {
                PhoneBook p2 = result.get(k2);
                commonContacts.addAll(intersect(p1, p2));
            }
        }
        System.out.println("--------------");
        System.out.println(commonContacts);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static void findToSet(List<PhoneBook> result) {
        Instant start = Instant.now();
        Set<Collection> commonContacts = new HashSet<>();
        for (int k1 = 0; k1 < result.size(); k1++) {
            PhoneBook p1 = result.get(k1);
            for (int k2 = k1 + 1; k2 < result.size() - k1; k2++) {
                PhoneBook p2 = result.get(k2);
                commonContacts.addAll(intersect(p1, p2));
            }
        }
        System.out.println("--------------");
        System.out.println(commonContacts);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    private static Abonent createAbonent(Abonent abonent) {
        abonent.createFio();
        abonent.createNumber();
        return abonent;
    }

    private static Collection<Abonent> createContacts(LinkedList<Abonent> bookPhone) {
        Random random = new Random();
        LinkedList<Abonent> contacts = new LinkedList<>();
        for (int j = 0; j < 100; j++) {
            contacts.add(bookPhone.get(random.nextInt(1000)));
        }
        return contacts;
    }
    private static List<Collection> intersect(PhoneBook p1, PhoneBook p2) {
        List<Collection> phoneBooksP1 = new ArrayList<>();
        phoneBooksP1.add(p1.getContacts());
        List<Collection> phoneBooksP2 = new ArrayList<>();
        phoneBooksP2.add(p2.getContacts());
        phoneBooksP1.removeAll(phoneBooksP2);
        return phoneBooksP1;
    }
}
