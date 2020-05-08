package hu.uszeged.stud.gmbalint.webshop.service;

import hu.uszeged.stud.gmbalint.webshop.domain.FormField;

public interface InputService {
    void getInput(FormField field);

    String getString();
    String getNotNullString();
    boolean getBoolean();
    int getInt();
    double getDouble();
}
