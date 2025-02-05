package net.brifboy.rolebot;


import net.brifboy.rolebot.actions.MessageLoggService;
import net.brifboy.rolebot.actions.MessageService;
import net.brifboy.rolebot.actions.UserInterectService;
import net.brifboy.rolebot.commands.RoleBotCommands;
import net.brifboy.rolebot.commands.CommandRoleSelectService;
import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Service;

@Service
public class RoleBotService {
    public JDA jda;
    public RoleBotCommands roleBotCommands;
    public MessageService messageService;
    public CommandRoleSelectService commandRoleSelectService;
    public UserInterectService userInterectService;
    protected MessageLoggService messageLoggService;
    public static boolean Departmentrolesset;
    public static boolean Classrolesset;

    public RoleBotService(RoleBotCommands roleBotCommands, MessageService messageService, CommandRoleSelectService commandRoleSelectService,
                          UserInterectService userInterectService, MessageLoggService messageLoggService) {
        this.roleBotCommands = roleBotCommands;
        this.messageService = messageService;
        this.commandRoleSelectService = commandRoleSelectService;
        this.userInterectService = userInterectService;
        this.messageLoggService = messageLoggService;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }
}
