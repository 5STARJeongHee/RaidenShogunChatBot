package discord.bot;

import discord.bot.properties.MyProperties;
import discord.bot.util.FileUtils;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String filePath = "application.yml";
        URL resource = Main.class.getClassLoader().getResource(filePath);
        System.out.println(resource.getPath());
        MyProperties properties = (MyProperties) FileUtils.loadYamlObject(resource.getPath(), MyProperties.class);

        RaidenShogunChatBot bot = new RaidenShogunChatBot(properties.getDiscord().getToken());
        bot.addMessageListener("!ping", "pong!!");
    }
}