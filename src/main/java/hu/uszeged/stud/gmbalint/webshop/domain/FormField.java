package hu.uszeged.stud.gmbalint.webshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FormField {
    private String name;
    private FieldType dataType;
    private Object value;
}
