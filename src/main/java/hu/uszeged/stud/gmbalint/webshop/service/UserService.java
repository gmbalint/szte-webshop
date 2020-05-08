package hu.uszeged.stud.gmbalint.webshop.service;

import hu.uszeged.stud.gmbalint.webshop.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String userName, String password);
    void register(String firstName, String lastName, String userName, String password);
}
