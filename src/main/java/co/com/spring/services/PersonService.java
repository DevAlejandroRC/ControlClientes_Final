package co.com.spring.services;

import co.com.spring.domain.Person;
import java.util.List;

public interface PersonService {
    
    public List<Person> listPersons();
    
    public void save(Person person);
    public void delete(Person person);
    
    public Person searchByPerson(Person person);
}
