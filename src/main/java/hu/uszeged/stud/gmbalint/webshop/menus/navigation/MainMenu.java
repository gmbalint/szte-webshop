package hu.uszeged.stud.gmbalint.webshop.menus.navigation;

import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.domain.MenuOption;
import hu.uszeged.stud.gmbalint.webshop.menus.NavigationMenu;
import hu.uszeged.stud.gmbalint.webshop.menus.form.ShopMenu;
import hu.uszeged.stud.gmbalint.webshop.menus.form.UploadCreditMenu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainMenu extends NavigationMenu {
    private final ShopMenu shopMenu;
    private final ProfileMenu profileMenu;
    private final UploadCreditMenu uploadCreditMenu;
    private final OrdersMenu ordersMenu;

    public MainMenu(final ShopMenu shopMenu,
                    final ProfileMenu profileMenu,
                    final OrdersMenu ordersMenu,
                    final UploadCreditMenu uploadCreditMenu) {
        this.shopMenu = shopMenu;
        this.profileMenu = profileMenu;
        this.uploadCreditMenu = uploadCreditMenu;
        this.ordersMenu = ordersMenu;
    }

    public void setUser(User user) {
        this.shopMenu.setUser(user);
        this.profileMenu.setUser(user);
        this.uploadCreditMenu.setUser(user);
        this.ordersMenu.setUser(user);
    }

    @Override
    protected List<MenuOption> initMenuOptions() {
        this.shopMenu.setParentMenu(this);
        this.profileMenu.setParentMenu(this);
        this.ordersMenu.setParentMenu(this);
        this.uploadCreditMenu.setParentMenu(this);

        return List.of(
                new MenuOption("Buy products", this.shopMenu),
                new MenuOption("View profile", this.profileMenu),
                new MenuOption("View orders", this.ordersMenu),
                new MenuOption("Upload credit", this.uploadCreditMenu)
        );
    }
}
