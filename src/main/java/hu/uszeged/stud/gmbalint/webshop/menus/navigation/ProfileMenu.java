package hu.uszeged.stud.gmbalint.webshop.menus.navigation;

import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.domain.MenuOption;
import hu.uszeged.stud.gmbalint.webshop.menus.NavigationMenu;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileMenu extends NavigationMenu {
    @Setter
    private User user;

    /**
     * Display text for the menu. No content by default.
     */
    @Override
    protected void displayText() {
        super.displayText();
        System.out.println("Your profile:");
        System.out.println();

        System.out.print("- First name: ");
        System.out.println(user.getFirstName());
        System.out.print("- Last name: ");
        System.out.println(user.getLastName());
        System.out.print("- User name: ");
        System.out.println(user.getUserName());
        System.out.print("- Credit: ");
        System.out.printf("%s $\n", user.getCredit());
        System.out.println();
    }

    @Override
    protected List<MenuOption> initMenuOptions() {
        return List.of();
    }
}
