package net.brifboy.rolebot.commands;


import net.brifboy.rolebot.RolebotApplication;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class SendRoleSelectService extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getSubcommandName().equals("location")) {
            event.reply("Done").queue();

            RolebotApplication.roleBotService.messageService.sendLocationMessage(event, event.getOption("channelid").getAsString());


        } else if (event.getSubcommandName().equals("class")) {
            event.reply("Done").queue();

            RolebotApplication.roleBotService.messageService.sendClassMessage(event, event.getOption("channelid").getAsString());
        } else if (event.getSubcommandName().equals("clearroles")) {
            RolebotApplication.roleBotService.messageService.sendClearRolesMessage(event, event.getOption("channelid").getAsString());
            event.reply("Done").queue();
        }

    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("fagerlia")) {
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1320440327466782783")).queue();
            RolebotApplication.roleBotService.messageService.sendClassMessage(event);
        } else if (event.getButton().getId().equals("volsdalsberga")) {
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1320710889283915809")).queue();
            RolebotApplication.roleBotService.messageService.sendClassMessage(event);
        }

        if (event.getButton().getId().equals("clearroles")) {
            for (Role role : event.getMember().getRoles()) {
                event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
            }
            event.reply("Done").queue();

        }
    }

    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {

         switch (event.getSelectedOptions().getFirst().getValue()) {
             case "1IM": event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1320516758041526293")).queue(); break;
             default: event.reply("Something whent wrong! please try again").queue();
         }
         event.reply("Done").queue();
    }

}
