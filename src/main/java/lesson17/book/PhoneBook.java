package lesson17.book;

import lombok.Data;
import java.util.Collection;

@Data
public class PhoneBook {
    private Abonent abonent;
    private Collection<Abonent> contacts;
}
