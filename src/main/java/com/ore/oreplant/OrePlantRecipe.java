package com.ore.oreplant;

import com.ore.oreplant.oreblock.OreBlock;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 所有合成表
 * @author 卿岚
 */
public class OrePlantRecipe {

    public static void init(FMLInitializationEvent event) {
    	//甘蔗
		GameRegistry.addSmelting(Crops.reedCoal, new ItemStack(Items.COAL, 1,0), 5.0f);
		GameRegistry.addSmelting(Crops.reedDiamond, new ItemStack(Items.DIAMOND, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedEmerald, new ItemStack(Items.EMERALD, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedGlowstone, new ItemStack(Items.GLOWSTONE_DUST, 2), 5.0f);
		GameRegistry.addSmelting(Crops.reedGold, new ItemStack(Items.GOLD_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedIron, new ItemStack(Items.IRON_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedLapis, new ItemStack(Items.DYE, 2,4), 5.0f);
		GameRegistry.addSmelting(Crops.reedObsidian, new ItemStack(Blocks.OBSIDIAN, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedQuartz, new ItemStack(Items.QUARTZ, 2), 5.0f);
		GameRegistry.addSmelting(Crops.reedRedstone, new ItemStack(Items.REDSTONE, 2), 5.0f);
		//树干
		GameRegistry.addSmelting(Crops.woodCoal, new ItemStack(Items.COAL, 1,0), 5.0f);
		GameRegistry.addSmelting(Crops.woodDiamond, new ItemStack(Items.DIAMOND, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodEmerald, new ItemStack(Items.EMERALD, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodGlowstone, new ItemStack(Items.GLOWSTONE_DUST, 2), 5.0f);
		GameRegistry.addSmelting(Crops.woodGold, new ItemStack(Items.GOLD_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodIron, new ItemStack(Items.IRON_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodLapis, new ItemStack(Items.DYE, 2,4), 5.0f);
		GameRegistry.addSmelting(Crops.woodRedstone, new ItemStack(Items.REDSTONE, 2), 5.0f);
		GameRegistry.addSmelting(Crops.woodObsidian, new ItemStack(Blocks.OBSIDIAN, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodQuartz, new ItemStack(Items.QUARTZ, 2), 5.0f);
		//劣质钻石矿
		GameRegistry.addSmelting(OreBlock.diamond_ore, new ItemStack(Items.DIAMOND, 1), 5.0f);
    }
}
