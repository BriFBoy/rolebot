package net.brifboy.rolebot;


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

    public RoleBotService(Commands commands, MessageService messageService, SendRoleSelectService sendRoleSelectService) {
        this.commands = commands;
        this.messageService = messageService;
        this.sendRoleSelectService = sendRoleSelectService;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }
}
