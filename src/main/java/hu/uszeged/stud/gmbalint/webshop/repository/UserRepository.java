package hu.uszeged.stud.gmbalint.webshop.repository;

import hu.uszeged.stud.gmbalint.webshop.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserNameAndPasswordHash(String username, String passwordHash);
}
