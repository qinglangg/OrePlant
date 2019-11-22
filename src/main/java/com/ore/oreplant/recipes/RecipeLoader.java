package com.ore.oreplant.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class RecipeLoader {

    public static void collect(String[] params) {
        File dir = new File("D:\\projects\\MC\\Forge\\OrePlant_1.7.10\\src\\main\\resources\\assets\\oreplant\\recipes");
        try {
            for (File file : dir.listFiles()) {
                JsonObject object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
                String type = object.get("type").getAsString();
                JsonArray pattern = object.getAsJsonArray("pattern");
                JsonObject keys = object.getAsJsonObject("key");
                JsonObject result = object.getAsJsonObject("result");

                if ("minecraft:crafting_shaped".equals(type)) {
                    StringBuilder sb = new StringBuilder("public static IRecipe ");
                    String name = file.getName();
                    sb.append(name.substring(0, name.indexOf('.')));
                    sb.append(" = new ShapedOreRecipe(");
                    sb.append(getItemStack(result)).append(", ");
                    for (JsonElement element : pattern) {
                        sb.append("\"" + element.getAsString() + "\"").append(", ");
                    }
                    for (Map.Entry<String, JsonElement> entry : keys.entrySet()) {
                        sb.append("\'" + entry.getKey().charAt(0) + "\'").append(", ");
                        JsonObject ingredient = entry.getValue().getAsJsonObject();
                        if (ingredient.has("type") && "forge:ore_dict".equals(ingredient.get("type").getAsString())) {
                            sb.append("\"" + ingredient.get("ore").getAsString() + "\"").append(", ");
                        } else {
                            sb.append(getItemStack(ingredient)).append(", ");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(");");
                    System.out.println(sb.toString());
                } else throw new IOException(file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getItemStack(JsonObject object) {
        String name = object.get("item").getAsString();
        int count = object.has("count") ? object.get("count").getAsInt() : 1;
        int meta = object.has("data") ? object.get("data").getAsInt() : 0;
        return "createItemStack(\"" + name + "\", " + count + ", " + meta + ")";
    }
}
