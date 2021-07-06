package lesson17.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class PhoneBook {
    private Abonent abonent;
    private Collection<Abonent> contacts;
}
