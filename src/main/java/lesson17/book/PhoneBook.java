package lesson17.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Collection;

@Data
@AllArgsConstructor
public class PhoneBook {
    private Abonent abonent;
    private Collection<Abonent> contacts;
}
