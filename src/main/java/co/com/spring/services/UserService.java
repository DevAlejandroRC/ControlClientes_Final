package co.com.spring.services;

import co.com.spring.dao.IUserDAO;
import co.com.spring.domain.Rol;
import co.com.spring.domain.JUser;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
@Transactional(readOnly = true)
public class UserService implements UserDetailsService{

    @Autowired
    private IUserDAO userDAO;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        JUser user = userDAO.findByUsername(username);
        
        if(user == null)
            throw new UsernameNotFoundException(username);
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol rol: user.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getRolName()));
        }
        
        return new User(user.getUsername(), user.getPassword(), roles);
    }
    
}
