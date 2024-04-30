package co.com.spring.dao;

import co.com.spring.domain.JUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO  extends JpaRepository<JUser, Long>{
    
    JUser findByUsername(String username);
    
}
