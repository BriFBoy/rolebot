package net.brifboy.rolebot.commands;


import net.brifboy.rolebot.RoleBotService;
import net.brifboy.rolebot.actions.MessageService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandRoleSelectService extends ListenerAdapter {
    @Autowired
    MessageService messageService;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals(RoleBotCommands.COMMANDSENDROLESELECT)) {
            switch (event.getSubcommandName()) {
                case RoleBotCommands.SUBCOMMANDLOCATION -> {
                    if (RoleBotService.Departmentrolesset) {
                        event.reply(messageService.getLocationMessage()).queue();
                    } else {
                        event.reply("Please set Department Roles").setEphemeral(true).queue();
                    }
                }
                case RoleBotCommands.SUBCOMMANDCLASSES -> {
                    if (RoleBotService.Classrolesset) {
                        event.reply(messageService.getClassMessage()).setEphemeral(true).queue();
                    } else {
                        event.reply("Please set Class Roles").setEphemeral(true).queue();
                    }
                }
                case RoleBotCommands.SUBCOMMANDCLEARROLES -> event.reply(messageService.getClearRolesMessage()).queue();
                case null, default -> {}
            }
        } else if (event.getName().equals(RoleBotCommands.COMMANDSETDEPARTMENTROLES)) {
            event.reply(messageService.getEntityDepartmentMenuMessage()).queue();
        } else if (event.getName().equals(RoleBotCommands.COMMANDSETCLASSROLES)) {
            event.reply(messageService.getEntityClassMenuMessage()).queue();
        }
    }



}
