package discord.bot.util;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static <T> Object loadYamlObject(String filePath, Class<T> clazz)  {
        Charset encoding = StandardCharsets.UTF_8;

        Object result = null;
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath, encoding));
        ){
            LoaderOptions options = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(clazz, options));
            result = yaml.load(br);
        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }
}
