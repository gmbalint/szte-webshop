package hu.uszeged.stud.gmbalint;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository {

    //nem írhatja felül semelyik öröklődő osztálya
    private final List<User> users = new ArrayList<>();

    public void load() {
        users.addAll(loadFromDb());
    }

    public void save() {
        saveToDb(this.users);
    }

    //list of users
    protected abstract List<User> loadFromDb();

    protected abstract void saveToDb(List<User> users);

    //lambda fgv.
    public boolean checkLogin(String userName, String password) {
        return this.users
                .stream()
                .anyMatch(user -> user.getUserName().equals(userName)
                        && user.getPassword().equals(password));
    }

    public void addUser(String firstName, String lastName, String userName, String password) {
        this.users.add(new User(firstName, lastName, userName, password,0));
    }

    // csak akkor használjuk, ha tudjuk, hogy van ilyen user
    public User getUser(String userName){
        return this.users.stream().filter(user -> user.getUserName().equals(userName)).findFirst().get();
    }
}
