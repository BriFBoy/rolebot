package net.brifboy.rolebot.actions;

import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {

    public List<Button> getLocationButtons() {
        List<Button> buttonList = new ArrayList<>();
        Button b1 = Button.primary("fagerlia", "Fagerlia");
        Button b2 = Button.primary("volsdalsberga", "Volsdalsberga");
        buttonList.add(b1);
        buttonList.add(b2);

        return buttonList;

    }
    public StringSelectMenu getClassMenu() {
        StringSelectMenu menu = StringSelectMenu.create("Classes")
                .addOption("1IM", "1IM")
                .build();
        return menu;

    }
    public List<Button> getClearButtons() {
        List<Button> buttonList = new ArrayList<>();
        Button b1 = Button.primary("clearroles", "Fjern Roller");
        buttonList.add(b1);

        return buttonList;

    }


}
