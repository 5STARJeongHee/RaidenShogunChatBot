package discord.bot.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscordProperties {
    String token;
    String[] intents;
}
