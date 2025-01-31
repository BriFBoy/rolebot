package net.brifboy.rolebot.commands;


import net.brifboy.rolebot.actions.MessageService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendRoleSelectService extends ListenerAdapter {
    @Autowired
    MessageService messageService;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getSubcommandName().equals(RoleBotCommands.SUBCOMMANDLOCATION)) {
            event.reply(messageService.getLocationMessage()).queue();

        } else if (event.getSubcommandName().equals(RoleBotCommands.SUBCOMMANDCLASSES)) {
            event.reply(messageService.getClassMessage()).queue();

        } else if (event.getSubcommandName().equals(RoleBotCommands.SUBCOMMANDCLEARROLES)) {
            event.reply(messageService.getClearRolesMessage()).queue();
        }

    }



}
