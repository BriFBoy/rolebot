package net.brifboy.rolebot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class RolebotApplication extends ListenerAdapter {
	public static RoleBotService roleBotService;
	private static final File TOKENFILE = new File(System.getProperty("user.dir") + "token.txt");
	private static final String USERDIR = System.getProperty("user.dir");


	public static void main(String[] args) throws InterruptedException, IOException {
		ApplicationContext appcon = SpringApplication.run(RolebotApplication.class, args);
		roleBotService = appcon.getBean(RoleBotService.class);

		try {
			roleBotService.setJda(JDABuilder.createDefault(getToken())
					.addEventListeners(roleBotService.sendRoleSelectService)
							.addEventListeners(roleBotService.userInterectService)
							.addEventListeners(roleBotService.messageLoggService)
					.build());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Token might be incorrect " + TOKENFILE.getPath());
		}

		roleBotService.jda.awaitReady();
		roleBotService.commands.createCommands();

	}
	private static String getToken() throws IOException {
		System.out.println(USERDIR);
        if (!TOKENFILE.exists()) {
            boolean filewascreate = TOKENFILE.createNewFile();
            System.out.println("file was created: " + filewascreate + ": " + TOKENFILE.getPath());
			System.out.println("Token needed in file");
			System.exit(0);
		}
        Scanner tokenscann = new Scanner(TOKENFILE);
        String token = tokenscann.nextLine();
        tokenscann.close();
        return token;
    }
}
