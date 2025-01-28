package net.brifboy.rolebot.actions;

import net.brifboy.rolebot.RoleBotService;
import net.brifboy.rolebot.RolebotApplication;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageLoggService extends ListenerAdapter {
    public List<String> messageidlogg = new ArrayList<>();
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
       if (event.getChannel().equals(RolebotApplication.roleBotService.jda.getTextChannelsByName("roles", true))) {
            messageidlogg.add(event.getMessage().getId());
        }
    }
}
