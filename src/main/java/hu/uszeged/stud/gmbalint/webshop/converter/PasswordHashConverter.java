package hu.uszeged.stud.gmbalint.webshop.converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHashConverter {
    private final PasswordEncoder passwordEncoder;

    public PasswordHashConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String hash(String password) {
        return password;
        //return passwordEncoder.encode(password);
    }
}
