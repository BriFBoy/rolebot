package net.brifboy.rolebot;

import net.brifboy.rolebot.actions.ActionService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    Embeds embeds;
    ActionService actionService;

    public MessageService(Embeds embeds, ActionService actionService) {
        this.embeds = embeds;
        this.actionService = actionService;
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
    public void replyClassMessage(ButtonInteractionEvent event) {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());
        event.reply(mb.build()).queue();

    }
    public MessageCreateData getClearRolesMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addActionRow(this.actionService.getClearButtons());
        return mb.build();

    }


}
