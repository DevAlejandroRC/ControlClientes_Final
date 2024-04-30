package co.com.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data //Crea estandar JavaBeans
@Entity
@Table(name = "persona")
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Long idperson;
    
    @Column(name = "nombre")
    @NotEmpty
    private String name; 
    
    @Column(name = "apellido",  nullable = false)
    @NotEmpty
    private String lastname;    
    
    @Column(name = "correo",  nullable = false)
    @NotEmpty
    @Email
    private String email;    
    
    @Column(name = "telefono")
    private String phone;   
    
}
