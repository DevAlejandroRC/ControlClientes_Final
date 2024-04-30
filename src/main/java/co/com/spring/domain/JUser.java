package co.com.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class JUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long iduser;
    
    @Column(name = "usuario")
    @NotEmpty
    private String username;
    
    @Column(name = "contrasena")
    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name = "idusuario")
    private List<Rol> roles;
    
}
