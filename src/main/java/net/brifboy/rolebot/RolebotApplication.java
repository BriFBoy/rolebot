package net.brifboy.rolebot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class RolebotApplication extends ListenerAdapter {
	public static RoleBotService roleBotService;



	public static void main(String[] args) throws InterruptedException {
		ApplicationContext appcon = SpringApplication.run(RolebotApplication.class, args);
		roleBotService = appcon.getBean(RoleBotService.class);
		if (args.length == 1) {
			try {
				roleBotService.setJda(JDABuilder.createDefault(args[0])
						.addEventListeners(roleBotService.commandRoleSelectService)
						.addEventListeners(roleBotService.userInterectService)
						.addEventListeners(roleBotService.messageLoggService)
						.build());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Token might be incorrect ");
			}
		} else {
			System.out.println("Token might be incorrect ");
			System.exit(1);
		}


		roleBotService.jda.awaitReady();
		roleBotService.roleBotCommands.createCommands();


	}
}
