package hu.uszeged.stud.gmbalint.webshop.menus.form;

import hu.uszeged.stud.gmbalint.webshop.domain.FieldType;
import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.domain.FormField;
import hu.uszeged.stud.gmbalint.webshop.menus.FormMenu;
import hu.uszeged.stud.gmbalint.webshop.repository.UserRepository;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UploadCreditMenu extends FormMenu {
    private final UserRepository userRepository;

    @Setter
    private User user;

    public UploadCreditMenu(final UserRepository userRepository) {
        this.userRepository = userRepository;
        this.setNeedsConfirmation(true);
    }

    /**
     * Display text for the menu. No content by default.
     */
    @Override
    protected void displayText() {
        super.displayText();

        System.out.println("Upload credit");
        System.out.println();
    }

    @Override
    protected void act() throws Exception {
        final FormField amountField = getFields().get(0);
        final double amount = (double) amountField.getValue();

        if (amount < 1) throw new Exception("You have to upload at least 1 $ per transaction");

        user.setCredit(user.getCredit() + amount);
        userRepository.save(user);
        setNextMenu(this.getParentMenu());
    }

    @Override
    protected List<FormField> initFields() {
        return List.of(
                new FormField("Amount", FieldType.Double, 0)
        );
    }
}
