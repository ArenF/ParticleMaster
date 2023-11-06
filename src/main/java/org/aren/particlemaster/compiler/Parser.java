package org.aren.particlemaster.compiler;

import org.bukkit.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Parser {

    public static void parse(JSONArray array) {

        JSONArray parsedArray = new JSONArray();

        List<String> keywords = Arrays.asList("addDot", "addLine", "Vector", "loop", "sin", "cos", "tan");

        for (int i = 0; i < array.size(); i++) {
            JSONObject data = (JSONObject) array.get(i);
            TokenType type = TokenType.valueOf((String) data.get("type"));
            String value = (String) data.get("value");

            if (type.equals(TokenType.LETTER)) {
                
            }

        }
    }
}
