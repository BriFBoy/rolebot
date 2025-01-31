package net.brifboy.rolebot.commands;

import net.brifboy.rolebot.RolebotApplication;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import org.springframework.stereotype.Service;

@Service
public class RoleBotCommands {

    protected static final String COMMANDSENDROLESELECT = "sendroleselect";
    protected static final String SUBCOMMANDLOCATION = "location";
    protected static final String SUBCOMMANDCLASSES = "class";
    protected static final String SUBCOMMANDCLEARROLES = "clearroles";
    protected static final String OPTIONCHANNELID = "channelid";


    public void createCommands() {
       RolebotApplication.roleBotService.jda.getGuildById("1302710445139951657").updateCommands()
                .addCommands(net.dv8tion.jda.api.interactions.commands.build.Commands.slash(COMMANDSENDROLESELECT, "sends a embed that lets you choose roles")
                .addSubcommands(new SubcommandData(SUBCOMMANDLOCATION, "send for selecting location roles")
                        .addOption(OptionType.STRING, OPTIONCHANNELID, "where to send message", true))
                .addSubcommands(new SubcommandData(SUBCOMMANDCLASSES, "send for selecting class roles")
                        .addOption(OptionType.STRING, OPTIONCHANNELID, "where to send message", true))
                        .addSubcommands(new SubcommandData(SUBCOMMANDCLEARROLES, "sends a message that can clear roles")
                                .addOption(OptionType.STRING, OPTIONCHANNELID, "where to send message", true)))
                .queue();
    }
}
