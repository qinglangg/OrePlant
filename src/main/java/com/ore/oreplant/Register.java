package com.ore.oreplant;

import com.ore.oreplant.ores.OreBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

public class Register {

    public static ArrayList<Item> ITEMS = new ArrayList<>();
    public static ArrayList<Block> BLOCKS = new ArrayList<>();

    public static void register() {
        try {
            ArrayList<Field> fields = new ArrayList<>();
            Collections.addAll(fields, Crops.class.getFields());
            Collections.addAll(fields, Seeds.class.getFields());
            Collections.addAll(fields, OreBlock.class.getFields());
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    if (Item.class.isAssignableFrom(field.getType())) {
                        registerItem((Item) field.get(null), field.getName().toLowerCase());
                    } else if (Block.class.isAssignableFrom(field.getType())) {
                        registerBlock((Block) field.get(null), field.getName().toLowerCase());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void registerItem(Item item, String name) {
        item.setUnlocalizedName(OrePlant.MODID + "." + name);
        GameRegistry.registerItem(item, name);
        ITEMS.add(item);
    }

    public static void registerBlock(Block block, String name) {
        block.setBlockName(OrePlant.MODID + "." + name);
        GameRegistry.registerBlock(block, name);
        BLOCKS.add(block);
    }
}
