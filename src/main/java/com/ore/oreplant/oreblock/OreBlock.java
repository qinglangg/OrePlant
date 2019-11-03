package com.ore.oreplant.oreblock;

import com.elementtimes.elementcore.api.annotation.ModBlock;
import com.ore.oreplant.OreTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreBlock {
    @ModBlock
    @ModBlock.WorldGenClass("com.elementtimes.tutorial.common.generator.SulfurGenerator")
    public static Block gold_ore = new Gold_ore();
    @ModBlock
    @ModBlock.WorldGenClass("com.elementtimes.tutorial.common.generator.SulfurGenerator")
    public static Block iron_ore = new Iron_ore();
    @ModBlock
    @ModBlock.HarvestLevel
    @ModBlock.WorldGen
    public static Block diamond_ore = new Block(Material.ROCK).setHardness(8f).setResistance(5f).setCreativeTab(OreTabs.TAB);
}
