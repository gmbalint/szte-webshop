package hu.uszeged.stud.gmbalint.webshop.service.impl;

import hu.uszeged.stud.gmbalint.webshop.domain.FormField;
import hu.uszeged.stud.gmbalint.webshop.service.InputService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class InputServiceImpl implements InputService {

    private Scanner scanner;

    public InputServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getInput(FormField field) {
        System.out.printf("%s: ", field.getName());

        switch (field.getDataType()) {
            case String:
                field.setValue(getNotNullString());
                break;
            case Int:
                field.setValue(getInt());
                break;
            case Double:
                field.setValue(getDouble());
                break;
            case Boolean:
                field.setValue(getBoolean());
                break;
            case OptionalString:
                field.setValue(getString());
                break;
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getNotNullString() {
        while (true) {
            final String input = getString();
            if (!input.equals("")) return input;
            System.out.println("Invalid, try again!");
        }
    }

    public boolean getBoolean() {
        while (true) {
            final String input = getString();
            try {
                return Boolean.parseBoolean(input);
            } catch (Exception e) {
                System.out.println("Invalid, try again!");
            }
        }
    }

    public int getInt() {
        while (true) {
            final String input = getString();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid, try again!");
            }
        }
    }

    public double getDouble() {
        while (true) {
            final String input = getString();
            try {
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Invalid, try again!");
            }
        }
    }
}
