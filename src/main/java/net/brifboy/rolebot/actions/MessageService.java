package net.brifboy.rolebot.actions;

import net.brifboy.rolebot.Embeds;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    Embeds embeds;
    ActionService actionService;
    MessageLoggService messageLoggService;


    public MessageService(Embeds embeds, ActionService actionService, MessageLoggService messageLoggService) {
        this.embeds = embeds;
        this.actionService = actionService;
        this.messageLoggService = messageLoggService;
    }
    public MessageCreateData getLocationMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getLocationEmbed());
        mb.addActionRow(this.actionService.getLocationButtons());

        return  mb.build();
    }

    public MessageCreateData getClassMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());

        return  mb.build();

    }

    public void replyClassMessageAutoDel(ButtonInteractionEvent event) {
        MessageCreateBuilder mb = new MessageCreateBuilder();

        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());
        event.reply(mb.build()).setEphemeral(true).queue();

    }

    public MessageCreateData getClearRolesMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addActionRow(this.actionService.getClearButtons());
        return mb.build();

    }
    public MessageCreateData getEntityDepartmentMenuMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addActionRow(actionService.getdepartmentRoleMenu());
        return mb.build();
    }
    public MessageCreateData getEntityClassMenuMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addActionRow(actionService.getClassRoleMenu());
        return mb.build();
    }


}
