package net.brifboy.rolebot;


import net.brifboy.rolebot.actions.MessageLoggService;
import net.brifboy.rolebot.actions.UserInterectService;
import net.brifboy.rolebot.commands.Commands;
import net.brifboy.rolebot.commands.SendRoleSelectService;
import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Service;

@Service
public class RoleBotService {
    public JDA jda;
    public Commands commands;
    public MessageService messageService;
    public SendRoleSelectService sendRoleSelectService;
    public UserInterectService userInterectService;
    protected MessageLoggService messageLoggService;

    public RoleBotService(Commands commands, MessageService messageService, SendRoleSelectService sendRoleSelectService,
                          UserInterectService userInterectService, MessageLoggService messageLoggService) {
        this.commands = commands;
        this.messageService = messageService;
        this.sendRoleSelectService = sendRoleSelectService;
        this.userInterectService = userInterectService;
        this.messageLoggService = messageLoggService;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }
}
