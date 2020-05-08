package hu.uszeged.stud.gmbalint.webshop.menus.form;

import hu.uszeged.stud.gmbalint.webshop.entity.Product;
import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.domain.FieldType;
import hu.uszeged.stud.gmbalint.webshop.domain.FormField;
import hu.uszeged.stud.gmbalint.webshop.menus.FormMenu;
import hu.uszeged.stud.gmbalint.webshop.service.OrderService;
import hu.uszeged.stud.gmbalint.webshop.service.ProductService;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ShopMenu extends FormMenu {
    private final OrderService orderService;
    private final ProductService productService;
    private final UploadCreditMenu uploadCreditMenu;

    @Setter
    private User user;

    public ShopMenu(final OrderService orderService, final ProductService productService, final UploadCreditMenu uploadCreditMenu) {
        this.orderService = orderService;
        this.productService = productService;
        this.uploadCreditMenu = uploadCreditMenu;
        this.setNeedsConfirmation(true);
    }

    @Override
    protected void displayText() {
        super.displayText();
        System.out.printf("Hellobello, %s!\n", user.getUserName());
        System.out.println();
        System.out.println("ID - Name - Price - Quantity");
        productService.getAllProducts().forEach(product -> {
            System.out.printf("%d - %s - %s $ - %d pcs\n", product.getId(), product.getName(), product.getPrice(), product.getQuantity());
        });

        System.out.println("Choose which product to buy:");
    }

    @Override
    protected void act() throws Exception {
        final FormField productIdField = getFields().get(0);
        final FormField quantityField = getFields().get(1);
        final int productId = (int) productIdField.getValue();
        final int quantity = (int) quantityField.getValue();

        if (quantity < 1) throw new Exception("Invalid quantity");

        final Optional<Product> product = productService.getProduct(productId);

        if (product.isEmpty()) throw new Exception("Invalid product id");
        if (quantity > product.get().getQuantity()) throw new Exception("We do not have this much of this product");
        if (user.getCredit() < quantity * product.get().getPrice()) {
            System.out.println("You don't have enough money");

            uploadCreditMenu.setUser(user);
            setNextMenu(uploadCreditMenu);
        } else {
            orderService.placeOrder(user, Map.of(product.get(), quantity));
            setNextMenu(this.getParentMenu());
        }
    }

    @Override
    protected List<FormField> initFields() {
        return List.of(
                new FormField("Product ID", FieldType.Int, null),
                new FormField("Quantity", FieldType.Int, null)
        );
    }
}
