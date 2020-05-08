package hu.uszeged.stud.gmbalint.webshop.menus.navigation;

import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.domain.MenuOption;
import hu.uszeged.stud.gmbalint.webshop.menus.NavigationMenu;
import hu.uszeged.stud.gmbalint.webshop.service.OrderService;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersMenu extends NavigationMenu {
    private final OrderService orderService;

    @Setter
    private User user;

    public OrdersMenu(final OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Display text for the menu. No content by default.
     */
    @Override
    protected void displayText() {
        super.displayText();

        System.out.println("Your previous orders:");
        System.out.println();

        orderService.listOrders(user).forEach(order -> {
            System.out.printf("%s:\n", order.getOrderTime());
            order.getItems().forEach(item -> {
                System.out.printf("%s, %s pcs, %s $ / pcs\n",
                        item.getProduct().getName(), item.getQuantity(), item.getPrice());
            });
            System.out.println();
        });
    }

    @Override
    protected List<MenuOption> initMenuOptions() {
        return List.of();
    }
}
