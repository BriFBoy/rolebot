package net.brifboy.rolebot.actions;

import net.brifboy.rolebot.Embeds;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


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
    public void replyClassselectuservis(ButtonInteractionEvent event) {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());
        event.reply(mb.build()).setEphemeral(true).queue();

    }
    public void replyClassMessageAutoDel(ButtonInteractionEvent event) {
        MessageCreateBuilder mb = new MessageCreateBuilder();

        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());
        event.reply(mb.build()).setEphemeral(true).queue();

    }

    private void delMessageTimer(ButtonInteractionEvent event) {
        String messageid = event.getChannel().getLatestMessageId();
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        s.schedule(() -> {
            if (messageLoggService.messageidlogg.getLast().equals(messageid)) {
              messageLoggService.deleteLatestMessage(event);
            }
        }, 5, TimeUnit.SECONDS);
        s.shutdown();
    }

    public MessageCreateData getClearRolesMessage() {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addActionRow(this.actionService.getClearButtons());
        return mb.build();

    }


}
