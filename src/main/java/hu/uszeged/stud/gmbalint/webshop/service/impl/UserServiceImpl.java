package hu.uszeged.stud.gmbalint.webshop.service.impl;

import hu.uszeged.stud.gmbalint.webshop.converter.PasswordHashConverter;
import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.repository.UserRepository;
import hu.uszeged.stud.gmbalint.webshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordHashConverter passwordHashConverter;

    public UserServiceImpl(UserRepository userRepository, PasswordHashConverter passwordHashConverter) {
        this.userRepository = userRepository;
        this.passwordHashConverter = passwordHashConverter;
    }

    @Override
    public Optional<User> login(String userName, String password) {
        return Optional.ofNullable(
                userRepository.findByUserNameAndPasswordHash(userName, passwordHashConverter.hash(password))
        );
    }

    @Override
    public void register(String firstName, String lastName, String userName, String password) {
        final User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .userName(userName)
                .passwordHash(passwordHashConverter.hash(password))
                .credit(0)
                .build();

        userRepository.save(user);
        System.out.println("Registration successful.");
    }
}
