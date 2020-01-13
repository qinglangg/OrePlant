package com.ore.oreplant.ores;

import com.ore.oreplant.OreTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreBlock {
    public static Block gold_ore = new Gold_ore();
    public static Block iron_ore = new Iron_ore();
    public static Block gold_ore2 = new Gold_ore2();
    public static Block iron_ore2 = new Iron_ore2();
    public static Block diamond_ore = new Block(Material.rock) {{setHarvestLevel("pickaxe", 2);}}.setBlockTextureName("oreplant:diamond_ore").setHardness(8f).setResistance(5f).setCreativeTab(OreTabs.TAB);
    public static Block diamond_ore2 = new Block(Material.rock) {{setHarvestLevel("pickaxe", 2);}}.setBlockTextureName("oreplant:diamond_ore").setHardness(10f).setResistance(6f).setCreativeTab(OreTabs.TAB);
}
