package net.brifboy.rolebot.actions;

import net.brifboy.rolebot.Roles;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {




    protected static final String BUTTONCLEARROLES = "clearroles";
    protected static final String MENUCLASSES = "classes";
    protected static final String ENTITYDEPARTMENTMENU = "departmentmenu";
    protected static final String ENTITYCLASSMENU = "classmenu";

    public List<Button> getLocationButtons() {
        List<Button> buttonList = new ArrayList<>();
        for (Role r : Roles.departmentroles) {
            buttonList.add(Button.primary(r.getName(), r.getName()));
        }
        return buttonList;

    }
    public StringSelectMenu getClassMenu() {
        List<SelectOption> sl = new ArrayList<>();
        for (Role r : Roles.classesroles) {
            sl.add(SelectOption.of(r.getName(), r.getName()));
        }
        return StringSelectMenu.create(MENUCLASSES).addOptions(sl).build();
    }
    public List<Button> getClearButtons() {
        List<Button> buttonList = new ArrayList<>();
        Button b1 = Button.primary(BUTTONCLEARROLES, "Fjern Roller");
        buttonList.add(b1);

        return buttonList;
    }

    public static String capFirstLetter(String unpcaped) {
        char[] charlist = unpcaped.toCharArray();
        String caped = String.valueOf(charlist[0]).toUpperCase();
        StringBuilder rest = new StringBuilder();
        for (int a = 1; a < charlist.length; a++) {
            rest.append(charlist[a]);
        }
        return caped + rest;
    }
    public EntitySelectMenu getdepartmentRoleMenu() {
        return EntitySelectMenu.create(ENTITYDEPARTMENTMENU, EntitySelectMenu.SelectTarget.ROLE)
                .setMaxValues(25).setMinValues(1).build();
    }
    public EntitySelectMenu getClassRoleMenu() {
        return EntitySelectMenu.create(ENTITYCLASSMENU, EntitySelectMenu.SelectTarget.ROLE)
                .setMaxValues(25).setMinValues(1).build();
    }
}
