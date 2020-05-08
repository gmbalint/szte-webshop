package hu.uszeged.stud.gmbalint.webshop.menus;

import hu.uszeged.stud.gmbalint.webshop.domain.MenuOption;
import hu.uszeged.stud.gmbalint.webshop.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class NavigationMenu extends BaseMenu {
    private List<MenuOption> options;

    @Autowired
    private InputService inputService;

    protected abstract List<MenuOption> initMenuOptions();

    @Override
    public final void setParentMenu(Menu menu) {
        super.setParentMenu(menu);
        getOptions().add(generateBackMenuOption(menu));
    }

    public List<MenuOption> getOptions() {
        if (options == null) options = new ArrayList<>(this.initMenuOptions());
        return options;
    }

    public final void Display() throws IOException {
        displayText();
        presentChoices();

        final MenuOption choice = getChoice(getOptions().size());

        choice.getMenu().Display();
    }

    private void presentChoices() {
        System.out.println("Choose an option:");

        for (int i = 0; i < getOptions().size(); i++) {
            System.out.printf(" %d - %s\n", i + 1, getOptions().get(i).getName());
        }

        System.out.println();
    }

    private MenuOption getChoice(int max) {
        while (true) {
            System.out.print("Your choice: ");

            final int input = inputService.getInt();
            if (input <= max) return getOptions().get(input - 1);

            System.out.println("Invalid, try again!");
        }
    }

    private MenuOption generateBackMenuOption(Menu parent) {
        return MenuOption.builder()
                .name("Back")
                .menu(parent)
                .build();
    }
}
