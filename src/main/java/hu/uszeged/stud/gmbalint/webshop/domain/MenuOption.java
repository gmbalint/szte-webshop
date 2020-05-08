package hu.uszeged.stud.gmbalint.webshop.domain;

import hu.uszeged.stud.gmbalint.webshop.menus.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MenuOption {
    private String name;
    private Menu menu;
}
