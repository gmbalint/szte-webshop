package hu.uszeged.stud.gmbalint.webshop.menus;

import hu.uszeged.stud.gmbalint.webshop.domain.FormField;
import hu.uszeged.stud.gmbalint.webshop.service.InputService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public abstract class FormMenu extends BaseMenu {
    private String error = "";
    private List<FormField> fields;

    @Setter
    private boolean needsConfirmation = false;

    @Setter
    private Menu nextMenu;

    @Autowired
    private InputService inputService;

    protected abstract void act() throws Exception;

    protected abstract List<FormField> initFields();

    public List<FormField> getFields() {
        if (fields == null) fields = initFields();
        return fields;
    }

    public final void Display() throws IOException {
        displayErrors();
        displayText();
        displayForm();

        if (confirm()) {
            try {
                act();
            } catch (Exception e) {
                error = e.getMessage();
                Display();
                return;
            }
            nextMenu.Display();
        } else {
            getParentMenu().Display();
        }
    }

    private void displayErrors() {
        System.out.println(error);
    }

    private void displayForm() {
        getFields().forEach(inputService::getInput);
    }

    private boolean confirm() {
        if (!needsConfirmation) return true;
        System.out.println("Do you want to proceed? (true/false)");
        return inputService.getBoolean();
    }
}
