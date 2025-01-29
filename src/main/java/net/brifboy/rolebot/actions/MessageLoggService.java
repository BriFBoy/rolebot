package net.brifboy.rolebot.actions;


import net.brifboy.rolebot.RolebotApplication;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MessageLoggService extends ListenerAdapter {
    public List<String> messageidlogg = new ArrayList<>();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getChannel().equals(RolebotApplication.roleBotService.jda.getTextChannelById("1334135652282793984"))) {
            messageidlogg.add(event.getMessage().getId());
            System.out.println("add");
        }
    }
    public void deletePreviousMessage(StringSelectInteractionEvent event) {

        event.getChannel().deleteMessageById(messageidlogg.getLast()).queueAfter(5, TimeUnit.SECONDS);
        System.out.println(messageidlogg.getLast());
    }
    public void deleteMessage(Message message) {
        message.delete().queue();

    }
}
