package com.ore.oreplant.recipes;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.lang.reflect.Field;

public class CraftingRecipes {
    public static IRecipe reedcoal = new ShapedOreRecipe(createItemStack("oreplant:reedcoal", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:coal", 1, 0), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe reeddiamond = new ShapedOreRecipe(createItemStack("oreplant:reeddiamond", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:diamond", 1, 0), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe reedemerald = new ShapedOreRecipe(createItemStack("oreplant:reedemerald", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:emerald", 1, 0), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe reedgold = new ShapedOreRecipe(createItemStack("oreplant:reedgold", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:gold_ingot", 1, 0), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe reediron = new ShapedOreRecipe(createItemStack("oreplant:reediron", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:iron_ingot", 1, 0), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe reedlapis = new ShapedOreRecipe(createItemStack("oreplant:reedlapis", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:dye", 1, 4), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe reedredstone = new ShapedOreRecipe(createItemStack("oreplant:reedredstone", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:redstone", 1, 0), 'B', createItemStack("minecraft:reeds", 1, 0));
    public static IRecipe saplingcoal = new ShapedOreRecipe(createItemStack("oreplant:saplingcoal", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:coal", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe saplingdiamond = new ShapedOreRecipe(createItemStack("oreplant:saplingdiamond", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:diamond", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:diamond_block", 1, 0));
    public static IRecipe saplingemerald = new ShapedOreRecipe(createItemStack("oreplant:saplingemerald", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:emerald", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:emerald_block", 1, 0));
    public static IRecipe saplinggold = new ShapedOreRecipe(createItemStack("oreplant:saplinggold", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:gold_ingot", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:gold_block", 1, 0));
    public static IRecipe saplingiron = new ShapedOreRecipe(createItemStack("oreplant:saplingiron", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:iron_ingot", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:iron_block", 1, 0));
    public static IRecipe saplinglapis = new ShapedOreRecipe(createItemStack("oreplant:saplinglapis", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:dye", 1, 4), 'B', "treeSapling", 'C', createItemStack("minecraft:lapis_block", 1, 0));
    public static IRecipe saplingobsidian = new ShapedOreRecipe(createItemStack("oreplant:saplingobsidian", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:obsidian", 1, 0), 'B', "treeSapling");
    public static IRecipe saplingquartz = new ShapedOreRecipe(createItemStack("oreplant:saplingquartz", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:quartz", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:quartz_block", 1, 0));
    public static IRecipe saplingredstone = new ShapedOreRecipe(createItemStack("oreplant:saplingredstone", 1, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:redstone", 1, 0), 'B', "treeSapling", 'C', createItemStack("minecraft:redstone_block", 1, 0));
    public static IRecipe seedpumpkincoal = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkincoal", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:coal", 1, 0), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedpumpkindiamond = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkindiamond", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:diamond", 1, 0), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedpumpkinemerald = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkinemerald", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:emerald", 1, 0), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedpumpkingold = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkingold", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:gold_ingot", 1, 0), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedpumpkiniron = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkiniron", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:iron_ingot", 1, 0), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedpumpkinlapis = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkinlapis", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:dye", 1, 4), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedpumpkinredstone = new ShapedOreRecipe(createItemStack("oreplant:seedpumpkinredstone", 4, 0), "ABA", "BCB", "ABA", 'A', createItemStack("minecraft:redstone", 1, 0), 'B', createItemStack("minecraft:pumpkin_seeds", 1, 0), 'C', createItemStack("minecraft:coal_block", 1, 0));
    public static IRecipe seedwheatcoal = new ShapedOreRecipe(createItemStack("oreplant:seedwheatcoal", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:coal", 1, 0), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));
    public static IRecipe seedwheatdiamond = new ShapedOreRecipe(createItemStack("oreplant:seedwheatdiamond", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:diamond", 1, 0), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));
    public static IRecipe seedwheatemerald = new ShapedOreRecipe(createItemStack("oreplant:seedwheatemerald", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:emerald", 1, 0), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));
    public static IRecipe seedwheatgold = new ShapedOreRecipe(createItemStack("oreplant:seedwheatgold", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:gold_ingot", 1, 0), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));
    public static IRecipe seedwheatiron = new ShapedOreRecipe(createItemStack("oreplant:seedwheatiron", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:iron_ingot", 1, 0), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));
    public static IRecipe seedwheatlapis = new ShapedOreRecipe(createItemStack("oreplant:seedwheatlapis", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:dye", 1, 4), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));
    public static IRecipe seedwheatredstone = new ShapedOreRecipe(createItemStack("oreplant:seedwheatredstone", 1, 0), "ABA", "BAB", "ABA", 'A', createItemStack("minecraft:redstone", 1, 0), 'B', createItemStack("minecraft:wheat_seeds", 1, 0));

    private static ItemStack createItemStack(String name, int count, int meta) {
        if (GameData.getItemRegistry().containsKey(name)) {
            return new ItemStack(GameData.getItemRegistry().getObject(name), count, meta);
        } else if (GameData.getBlockRegistry().containsKey(name)) {
            return new ItemStack(GameData.getBlockRegistry().getObject(name), count, meta);
        } else {
            return new ItemStack(Blocks.air);
        }
    }

    public static void registerAll() {
        for (Field field : CraftingRecipes.class.getFields()) {
            try {
                IRecipe recipe = (IRecipe) field.get(null);
                GameRegistry.addRecipe(recipe);
            } catch (IllegalAccessException ignored) { }
        }
    }
}
