package net.brifboy.rolebot.actions;

import net.brifboy.rolebot.RoleBotService;
import net.brifboy.rolebot.Roles;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInterectService extends ListenerAdapter  {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageLoggService messageLoggService;
    @Autowired
    private ActionService actionService;


    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        for (Role r : Roles.departmentroles) {
            if (event.getButton().getId().equals(r.getName())) {
                event.getGuild().addRoleToMember(event.getMember(), r).queue();
                event.reply(messageService.getClassMessage()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals(ActionService.BUTTONCLEARROLES)) {
            for (Role role : event.getMember().getRoles()) {
                event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
            }
            event.reply("Done").submit().thenAccept((T) -> messageLoggService.deleteLatestMessage(event));
        }
    }

    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
        for (Role r : Roles.classesroles) {
            if (event.getSelectedOptions().getFirst().getValue().equals(r.getName())) {
                event.getGuild().addRoleToMember(event.getMember(), r).queue();
            }
        }
        event.reply("done").submit().thenAccept((v) -> messageLoggService.deleteLatestMessage(event));

       messageLoggService.deleteMessage(event.getMessage());


    }

    @Override
    public void onEntitySelectInteraction(@NotNull EntitySelectInteractionEvent event) {
            if (event.getComponentId().equals(ActionService.ENTITYDEPARTMENTMENU)) {
                Roles.departmentroles.clear();
                Roles.departmentroles.addAll(event.getMentions().getRoles());
                RoleBotService.Departmentrolesset = true;
                event.reply("done").setEphemeral(true).queue();
            } else if (event.getComponentId().equals(ActionService.ENTITYCLASSMENU)) {
                Roles.classesroles.addAll(event.getMentions().getRoles());
                RoleBotService.Classrolesset = true;
                event.reply("done").setEphemeral(true).queue();

            }
    }
}
