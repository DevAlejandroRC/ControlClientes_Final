package co.com.spring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
    public static void main(String[] args) {
        var password = "pazpass";
        System.out.println("password: "+password);
        System.out.println("password encriptado: "+encryptPass(password));
    }
    
    public static String encryptPass(String password){
        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
        return enconder.encode(password);
    }
}
