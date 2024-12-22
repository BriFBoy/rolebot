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

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class RolebotApplication extends ListenerAdapter {
	private static final JDA jda = JDABuilder.createDefault("token")
			.build();


	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RolebotApplication.class, args);
		jda.awaitReady();

		jda.getGuildById("1302710445139951657").updateCommands().addCommands(Commands.slash("sendroleselect", "sends a embed that lets you choose roles")
				.addSubcommands(new SubcommandData("plase", "send for selecting location roles"))
				.addSubcommands(new SubcommandData("class", "send for selecting class roles"))).queue();








	}
}
