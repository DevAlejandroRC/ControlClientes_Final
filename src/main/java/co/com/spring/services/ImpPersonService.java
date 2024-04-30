package co.com.spring.services;

import co.com.spring.dao.IPersonDAO;
import co.com.spring.domain.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImpPersonService implements PersonService{

    @Autowired
    private IPersonDAO personDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Person> listPersons() {
        return (List<Person>) personDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDAO.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person searchByPerson(Person person) {
        return personDAO.findById(person.getIdperson()).orElse(null);
    }
    
}
