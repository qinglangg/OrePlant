package com.ore.oreplant.recipes;

import com.ore.oreplant.Crops;
import com.ore.oreplant.plants.Reeds;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * 所有合成表
 * @author 卿岚
 */
public class SmeltRecipe {

    public static void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(Crops.woodCoal, new ItemStack(Items.coal, 1,0), 5.0f);
		GameRegistry.addSmelting(Crops.woodDiamond, new ItemStack(Items.diamond, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodEmerald, new ItemStack(Items.emerald, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodGold, new ItemStack(Items.gold_ingot, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodIron, new ItemStack(Items.iron_ingot, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodLapis, new ItemStack(Items.dye, 1,4), 5.0f);
		GameRegistry.addSmelting(Crops.woodRedstone, new ItemStack(Items.redstone, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodQuartz, new ItemStack(Items.quartz, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodObsidian, new ItemStack(Blocks.obsidian, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedCoal, new ItemStack(Items.coal, 1,0), 5.0f);
		GameRegistry.addSmelting(Crops.reedDiamond, new ItemStack(Items.diamond, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedEmerald, new ItemStack(Items.emerald, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedGlowstone, new ItemStack(Items.glowstone_dust, 2), 5.0f);
		GameRegistry.addSmelting(Crops.reedGold, new ItemStack(Items.gold_ingot, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedIron, new ItemStack(Items.iron_ingot, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedLapis, new ItemStack(Items.dye, 1,4), 5.0f);
		GameRegistry.addSmelting(Crops.reedObsidian, new ItemStack(Blocks.obsidian, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedQuartz, new ItemStack(Items.quartz, 1), 5.0f);
		GameRegistry.addSmelting(Crops.reedRedstone, new ItemStack(Items.redstone, 1), 5.0f);
    }
}
