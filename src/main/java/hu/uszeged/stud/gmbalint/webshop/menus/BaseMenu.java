package hu.uszeged.stud.gmbalint.webshop.menus;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Scanner;

public abstract class BaseMenu implements Menu {
    @Getter
    @Autowired
    private Scanner scanner;

    @Getter
    @Setter
    private Menu parentMenu;

    @Override
    public abstract void Display() throws IOException;

    /**
     * Display text for the menu. No content by default.
     */
    protected void displayText() {}
}
