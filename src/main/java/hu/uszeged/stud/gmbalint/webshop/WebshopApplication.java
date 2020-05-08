package hu.uszeged.stud.gmbalint.webshop;

import hu.uszeged.stud.gmbalint.webshop.menus.navigation.WelcomeMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
    private final WelcomeMenu welcomeMenu;

    public WebshopApplication(final WelcomeMenu welcomeMenu) {
        this.welcomeMenu = welcomeMenu;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        welcomeMenu.Display();
    }
}
