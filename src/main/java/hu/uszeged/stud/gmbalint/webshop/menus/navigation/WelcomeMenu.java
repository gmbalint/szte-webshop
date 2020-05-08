package hu.uszeged.stud.gmbalint.webshop.menus.navigation;

import hu.uszeged.stud.gmbalint.webshop.domain.MenuOption;
import hu.uszeged.stud.gmbalint.webshop.menus.NavigationMenu;
import hu.uszeged.stud.gmbalint.webshop.menus.form.LoginMenu;
import hu.uszeged.stud.gmbalint.webshop.menus.form.RegisterMenu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WelcomeMenu extends NavigationMenu {
    private final LoginMenu loginMenu;
    private final RegisterMenu registerMenu;

    public WelcomeMenu(final LoginMenu loginMenu, final RegisterMenu registerMenu) {
        this.loginMenu = loginMenu;
        this.registerMenu = registerMenu;
    }

    @Override
    protected void displayText() {
        super.displayText();

        System.out.println("Hello! This is my webshop.");
        System.out.println("Please choose an option to continue!");
    }

    @Override
    protected List<MenuOption> initMenuOptions() {
        this.loginMenu.setParentMenu(this);
        this.registerMenu.setParentMenu(this);

        return List.of(
                new MenuOption("Login", loginMenu),
                new MenuOption("Register", registerMenu)
        );
    }
}
