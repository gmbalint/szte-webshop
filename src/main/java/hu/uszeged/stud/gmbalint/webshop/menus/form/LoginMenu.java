package hu.uszeged.stud.gmbalint.webshop.menus.form;

import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.domain.FieldType;
import hu.uszeged.stud.gmbalint.webshop.domain.FormField;
import hu.uszeged.stud.gmbalint.webshop.menus.FormMenu;
import hu.uszeged.stud.gmbalint.webshop.menus.navigation.MainMenu;
import hu.uszeged.stud.gmbalint.webshop.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoginMenu extends FormMenu {

    private final UserService userService;
    private final MainMenu mainMenu;

    public LoginMenu(UserService userService, MainMenu mainMenu) {
        this.userService = userService;
        this.mainMenu = mainMenu;
        this.setNextMenu(mainMenu);
    }

    /**
     * Display text for the menu. No content by default.
     */
    @Override
    protected void displayText() {
        super.displayText();

        System.out.println("Please, log in:");
    }

    @Override
    protected void act() throws Exception {
        final FormField usernameField = getFields().get(0);
        final FormField passwordField = getFields().get(1);
        final String username = (String) usernameField.getValue();
        final String password = (String) passwordField.getValue();

        final Optional<User> user = userService.login(username, password);
        if (user.isEmpty()) throw new Exception("No such user");
        mainMenu.setUser(user.get());
    }

    @Override
    protected List<FormField> initFields() {
        this.mainMenu.setParentMenu(this);

        return List.of(
                new FormField("Username", FieldType.String, null),
                new FormField("Password", FieldType.String, null)
        );
    }
}
