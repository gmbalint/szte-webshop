package hu.uszeged.stud.gmbalint;

public class Main {

    public static void main(String[] args) {
        AbstractRepository repository = new TxtRepository("");
        repository.load();
        //regisztráció, bekér, repository addUser
        //bejelentkezés
        // login adatok beolvas
        boolean login = repository.checkLogin("", "");
        if (!login) {
            // fail
            return;
        }
        
        User user = repository.getUser("");
        
        // Hello user
        
        // Menü
        // 1. termékek
        // 2. előzmények
        // 3. pénzfeltöltés
        user.setCredit(user.getCredit() + 10);
        
        
        
        repository.save();
    }
    
}
