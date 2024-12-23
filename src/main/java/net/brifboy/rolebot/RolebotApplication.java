package net.brifboy.rolebot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class RolebotApplication extends ListenerAdapter {
	public static RoleBotService roleBotService;



	public static void main(String[] args) throws InterruptedException {
		ApplicationContext appcon = SpringApplication.run(RolebotApplication.class, args);
		roleBotService = appcon.getBean(RoleBotService.class);
		roleBotService.setJda(JDABuilder.createDefault("token")
						.addEventListeners(roleBotService.sendRoleSelectService)
				.build());
		roleBotService.jda.awaitReady();
		roleBotService.commands.createCommands();












	}
}
