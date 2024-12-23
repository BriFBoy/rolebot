package net.brifboy.rolebot.commands;

import net.brifboy.rolebot.RolebotApplication;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import org.springframework.stereotype.Service;

@Service
public class Commands {
    public void createCommands() {
        RolebotApplication.roleBotService.jda.getGuildById("1302710445139951657").updateCommands()
                .addCommands(net.dv8tion.jda.api.interactions.commands.build.Commands.slash("sendroleselect", "sends a embed that lets you choose roles")
                .addSubcommands(new SubcommandData("location", "send for selecting location roles")
                        .addOption(OptionType.STRING, "channelid", "where to send message", true))
                .addSubcommands(new SubcommandData("class", "send for selecting class roles")
                        .addOption(OptionType.STRING, "channelid", "where to send message", true))
                        .addSubcommands(new SubcommandData("clearroles", "sends a message that can clear roles")
                                .addOption(OptionType.STRING, "channelid", "where to send message", true)))
                .queue();
    }
}
