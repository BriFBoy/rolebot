package net.brifboy.rolebot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.springframework.stereotype.Service;

@Service
public class Embeds {

    public MessageEmbed getLocationEmbed() {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Velg Avdeling");

        return eb.build();
    }
    public MessageEmbed getClassEmbed() {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Velg Klasse");

        return eb.build();
    }



}
