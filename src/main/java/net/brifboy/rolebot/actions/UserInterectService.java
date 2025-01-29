package net.brifboy.rolebot.actions;

import net.brifboy.rolebot.MessageService;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserInterectService extends ListenerAdapter  {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageLoggService messageLoggService;

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        switch (event.getButton().getId()) {
            case "fagerlia": {event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1320440327466782783")).queue();
               this.messageService.replyClassMessage(event); break;}

            case "volsdalsberga": {event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1320710889283915809")).queue();
                this.messageService.replyClassMessage(event); break;}

            case "clearroles": {
                for (Role role : event.getMember().getRoles()) {
                    event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
                }
                event.reply("Done").queue();
            }
            default: {}
        }
    }

    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {

        switch (event.getSelectedOptions().getFirst().getValue()) {
            case "1IM": event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1320516758041526293")).queue(); break;
            default: event.reply("Something whent wrong! please try again").queue();
        }
        event.reply("done").submit().thenAccept((v) ->messageLoggService.deletePreviousMessage(event));

       messageLoggService.deleteMessage(event.getMessage());


    }




}
