package xyz.frish2021.bettitle.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.GameType;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonTitle {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    public File getTitleStringFile() {
        File file = new File(Minecraft.getInstance().gameDirectory, "title.json");
        return file;
    }

    public void saveJson(File file) {
        JsonObject object = new JsonObject();
        if (!file.exists()) {
            object.addProperty("title", "Minecraft 1.19.4");
            try {
                file.createNewFile();
                Files.write(file.toPath(), new GsonBuilder().setPrettyPrinting().create().toJson(object).getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTitle(File file) {
        String title;
        try {
            String title_1 = new Gson().fromJson(new String(FileUtils.readFileToString(file, "UTF-8")), JsonObject.class).get("title").getAsString();
            title = title_1.replace("${Minecraft_Version}", "1.19.4").replace("${Player_Name}", Minecraft.getInstance().getUser().getName()).replace("${Game_Time}", simpleDateFormat.format(date)).replace("${Game_Fps}", String.valueOf(Minecraft.getInstance().getFps()));
            return title;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
