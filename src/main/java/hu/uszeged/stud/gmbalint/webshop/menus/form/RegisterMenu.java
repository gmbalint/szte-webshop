package hu.uszeged.stud.gmbalint.webshop.menus.form;

import hu.uszeged.stud.gmbalint.webshop.domain.FieldType;
import hu.uszeged.stud.gmbalint.webshop.domain.FormField;
import hu.uszeged.stud.gmbalint.webshop.menus.FormMenu;
import hu.uszeged.stud.gmbalint.webshop.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterMenu extends FormMenu {

    private final UserService userService;

    public RegisterMenu(UserService userService, LoginMenu loginMenu) {
        this.userService = userService;
        this.setNextMenu(loginMenu);
    }

    /**
     * Display text for the menu. No content by default.
     */
    @Override
    protected void displayText() {
        super.displayText();

        System.out.println("Please, enter the following details:");
    }

    @Override
    protected void act() {
        final FormField firstNameField = getFields().get(0);
        final FormField lastNameField = getFields().get(1);
        final FormField userNameField = getFields().get(2);
        final FormField passwordField = getFields().get(3);
        final String firstName = (String) firstNameField.getValue();
        final String lastName = (String) lastNameField.getValue();
        final String userName = (String) userNameField.getValue();
        final String password = (String) passwordField.getValue();

        userService.register(firstName, lastName, userName, password);
    }

    @Override
    protected List<FormField> initFields() {
        return List.of(
                new FormField("First name", FieldType.String, null),
                new FormField("Last name", FieldType.String, null),
                new FormField("Username", FieldType.String, null),
                new FormField("Password", FieldType.String, null)
        );
    }
}
