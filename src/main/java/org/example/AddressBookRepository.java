package org.example;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long>{
    public AddressBook findById(long id);
}
