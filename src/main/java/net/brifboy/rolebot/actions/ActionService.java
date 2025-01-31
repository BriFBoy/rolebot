package net.brifboy.rolebot.actions;

import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {

    protected static final String BUTTONFAGERLIA = "fagerlia";
    protected static final String BUTTONVOLSDALSBERGA = "volsdalsberga";
    protected static final String BUTTONCLEARROLES = "clearroles";
    protected static final String MENUCLASSES = "classes";
    protected static final String MENUOPTION1IM = "1IM";

    public List<Button> getLocationButtons() {
        List<Button> buttonList = new ArrayList<>();
        Button b1 = Button.primary(BUTTONFAGERLIA, capFirstLetter(BUTTONFAGERLIA));
        Button b2 = Button.primary(BUTTONVOLSDALSBERGA, capFirstLetter(BUTTONVOLSDALSBERGA));
        buttonList.add(b1);
        buttonList.add(b2);

        return buttonList;

    }
    public StringSelectMenu getClassMenu() {
        return StringSelectMenu.create(MENUCLASSES)
                .addOption(MENUOPTION1IM, MENUOPTION1IM)
                .build();

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


}
