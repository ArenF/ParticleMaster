package org.aren.particlemaster;

import org.aren.particlemaster.compiler.Tokenizer;
import org.aren.particlemaster.compiler.exception.TypeErrorException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public final class ParticleMaster extends JavaPlugin {

    private JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        File file = new File(plugin.getDataFolder().getPath(), "test.pms");
        try {
            if (!file.exists()) {
                plugin.getDataFolder().mkdir();
                file.createNewFile();
            }

            BufferedReader r = new BufferedReader(new FileReader(file));
            List<Character> characterList = new ArrayList<>();

            System.out.println("코드를 가져왔습니다.");

            String s;
            while ((s = r.readLine()) != null) {
                char[] list = s.toCharArray();
                for (int i = 0; i < list.length; i++) {
                    characterList.add(list[i]);
                }
            }
            r.close();

            System.out.println("토크나이징 진행");

            JSONObject object = new JSONObject();
            object.put("type", "Program");
            object.put("body", Tokenizer.tokenize(characterList));

            System.out.println("토크나이징 완료");

            File jsonFile = new File(plugin.getDataFolder().getPath(), "test.json");
            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));

            object.writeJSONString(writer);

            writer.flush();
            writer.close();

        } catch (IOException | TypeErrorException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
