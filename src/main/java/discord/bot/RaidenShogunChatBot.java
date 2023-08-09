package discord.bot;

import lombok.RequiredArgsConstructor;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class RaidenShogunChatBot {
    private final String token;
    private DiscordApi api;

    public RaidenShogunChatBot(String token) {
        this.token = token;
        api = new DiscordApiBuilder().setToken(this.token).setAllIntents().login().join();
    }

    public void addMessageListener(String send, String response){
        api.addMessageCreateListener(e -> {
            if(e.getMessageContent().equalsIgnoreCase("!ping")){
                e.getChannel().sendMessage("Pong!");
            }
        });

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

}
