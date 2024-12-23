package net.brifboy.rolebot;

import net.brifboy.rolebot.actions.ActionService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    Embeds embeds;
    ActionService actionService;

    public MessageService(Embeds embeds, ActionService actionService) {
        this.embeds = embeds;
        this.actionService = actionService;
    }
    public void sendLocationMessage(SlashCommandInteractionEvent event, String channelid) {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getLocationEmbed());
        mb.addActionRow(this.actionService.getLocationButtons());

        event.getGuild().getTextChannelById(channelid).sendMessage(mb.build()).queue();
    }

    public void sendClassMessage(SlashCommandInteractionEvent event, String channelid) {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());

        event.getGuild().getTextChannelById(channelid).sendMessage(mb.build()).queue();

    }
    public void sendClassMessage(ButtonInteractionEvent event) {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addEmbeds(this.embeds.getClassEmbed());
        mb.addActionRow(this.actionService.getClassMenu());
        event.reply(mb.build()).queue();

    }
    public void sendClearRolesMessage(SlashCommandInteractionEvent event, String channelid) {
        MessageCreateBuilder mb = new MessageCreateBuilder();
        mb.addActionRow(this.actionService.getClearButtons());
        event.getGuild().getTextChannelById(channelid).sendMessage(mb.build()).queue();

    }


}
