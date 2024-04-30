package co.com.spring.dao;

import co.com.spring.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDAO extends JpaRepository<Person, Long>{
    
}
