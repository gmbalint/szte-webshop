package hu.uszeged.stud.gmbalint;

import java.util.ArrayList;
import java.util.List;

public class TxtRepository extends AbstractRepository {
    private final String filename;

    public TxtRepository(String filename) {
        super();
        this.filename = filename;
    }

    @Override
    protected List<User> loadFromDb() {
        return new ArrayList<>();
    }

    @Override
    protected void saveToDb(List<User> users) {

    }
}
