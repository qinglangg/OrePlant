package com.ore.oreplant;

import com.ore.oreplant.config.FlowerConfig;
import com.ore.oreplant.config.ReedConfig;
import com.ore.oreplant.plants.Flower;
import com.ore.oreplant.plants.PumpkinStem;
import com.ore.oreplant.plants.Reeds;
import com.ore.oreplant.plants.Wheat;
import com.ore.oreplant.plants.tree.Leaf;
import com.ore.oreplant.plants.tree.Wood;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockStem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Crops {

    public static BlockCrops wheatCoal = new Wheat("coal", () -> new ItemStack(Items.coal), () -> new ItemStack(Seeds.seedWheatCoal));
    public static BlockCrops wheatDiamond = new Wheat("diamond", () -> new ItemStack(Items.diamond),() -> new ItemStack(Seeds.seedWheatDiamond));
    public static BlockCrops wheatEmerald = new Wheat("emerald", () -> new ItemStack(Items.emerald), () -> new ItemStack(Seeds.seedWheatEmerald));
    public static BlockCrops wheatGold = new Wheat("gold", () -> new ItemStack(Items.gold_ingot), () -> new ItemStack(Seeds.seedWheatGold));
    public static BlockCrops wheatIron = new Wheat("iron", () -> new ItemStack(Items.iron_ingot), () -> new ItemStack(Seeds.seedWheatIron));
    public static BlockCrops wheatLapis = new Wheat("lapis", () -> new ItemStack(Items.dye, 1, 4), () -> new ItemStack(Seeds.seedWheatLapis));
    public static BlockCrops wheatRedstone = new Wheat("redstone", () -> new ItemStack(Items.redstone), () -> new ItemStack(Seeds.seedWheatRedstone));
    public static BlockCrops wheatQuartz = new Wheat("quartz", () -> new ItemStack(Items.quartz), () -> new ItemStack(Seeds.seedWheatQuartz));
    public static BlockCrops wheatObsidian = new Wheat("obsidian", () -> new ItemStack(Blocks.obsidian), () -> new ItemStack(Seeds.seedWheatObsidian));
    public static BlockCrops wheatGlowstone = new Wheat("glowstone", () -> new ItemStack(Items.glowstone_dust), () -> new ItemStack(Seeds.seedWheatGlowstone));

    public static BlockStem pumpkinCoalStem = new PumpkinStem(Blocks.coal_ore, Blocks.coal_ore, () -> Seeds.seedPumpkinCoal);
    public static BlockStem pumpkinDiamondStem = new PumpkinStem(Blocks.diamond_block, Blocks.diamond_ore, () -> Seeds.seedPumpkinDiamond);
    public static BlockStem pumpkinEmeraldStem = new PumpkinStem(Blocks.emerald_block, Blocks.emerald_ore, () -> Seeds.seedPumpkinEmerald);
    public static BlockStem pumpkinGoldStem = new PumpkinStem(Blocks.gold_block, Blocks.gold_ore, () -> Seeds.seedPumpkinGold);
    public static BlockStem pumpkinIronStem = new PumpkinStem(Blocks.iron_block, Blocks.iron_ore,() ->  Seeds.seedPumpkinIron);
    public static BlockStem pumpkinLapisStem = new PumpkinStem(Blocks.lapis_block, Blocks.lapis_ore, () -> Seeds.seedPumpkinLapis);
    public static BlockStem pumpkinRedstoneStem = new PumpkinStem(Blocks.redstone_block, Blocks.redstone_ore, () -> Seeds.seedPumpkinRedstone);
    public static BlockStem pumpkinQuartzStem = new PumpkinStem(Blocks.quartz_block, Blocks.quartz_ore, () -> Seeds.seedPumpkinQuartz);
    public static BlockStem pumpkinObsidianStem = new PumpkinStem(Blocks.obsidian, Blocks.obsidian, () -> Seeds.seedPumpkinObsidian);
    public static BlockStem pumpkinGlowstoneStem = new PumpkinStem(Blocks.glowstone, Blocks.glowstone, () -> Seeds.seedPumpkinGlowstone);

    public static Wood woodCoal = new Wood("coal");
    public static Wood woodDiamond = new Wood("diamond");
    public static Wood woodEmerald = new Wood("emerald");
    public static Wood woodGold = new Wood("gold");
    public static Wood woodIron = new Wood("iron");
    public static Wood woodLapis = new Wood("lapis");
    public static Wood woodRedstone = new Wood("redstone");
    public static Wood woodQuartz = new Wood("quartz");
    public static Wood woodObsidian = new Wood("obsidian");
    public static Wood woodGlowstone = new Wood("glowstone");

    public static Leaf leafCoal = new Leaf(Blocks.coal_block, () -> Seeds.saplingCoal);
    public static Leaf leafDiamond = new Leaf(Blocks.diamond_block, () -> Seeds.saplingDiamond);
    public static Leaf leafEmerald = new Leaf(Blocks.emerald_block, () -> Seeds.saplingEmerald);
    public static Leaf leafGold = new Leaf(Blocks.gold_block, () -> Seeds.saplingGold);
    public static Leaf leafIron = new Leaf(Blocks.iron_block, () -> Seeds.saplingIron);
    public static Leaf leafLapis = new Leaf(Blocks.lapis_block, () -> Seeds.saplingLapis);
    public static Leaf leafRedstone = new Leaf(Blocks.redstone_block, () -> Seeds.saplingRedstone);
    public static Leaf leafQuartz = new Leaf(Blocks.quartz_block, () -> Seeds.saplingQuartz);
    public static Leaf leafObsidian = new Leaf(Blocks.obsidian, () -> Seeds.saplingObsidian);
    public static Leaf leafGlowstone = new Leaf(Blocks.glowstone, () -> Seeds.saplingGlowstone);

    public static Reeds reedCoal = new Reeds(Blocks.coal_block, "reedcoal", () -> ReedConfig.coal);
    public static Reeds reedDiamond = new Reeds(Blocks.diamond_block, "reeddiamond", () -> ReedConfig.diamond);
    public static Reeds reedEmerald = new Reeds(Blocks.emerald_block, "reedemerald", () -> ReedConfig.emerald);
    public static Reeds reedGold = new Reeds(Blocks.gold_block, "reedgold", () -> ReedConfig.gold);
    public static Reeds reedIron = new Reeds(Blocks.iron_block, "reediron", () -> ReedConfig.iron);
    public static Reeds reedLapis = new Reeds(Blocks.lapis_block, "reedlapis", () -> ReedConfig.lapis);
    public static Reeds reedRedstone = new Reeds(Blocks.redstone_block, "reedredstone", () -> ReedConfig.redstone);
    public static Reeds reedQuartz = new Reeds(Blocks.quartz_block, "reedquartz", () -> ReedConfig.quartz);
    public static Reeds reedObsidian = new Reeds(Blocks.obsidian, "reedobsidian", () -> ReedConfig.obsidian);
    public static Reeds reedGlowstone = new Reeds(Blocks.glowstone, "reedglowstone", () -> ReedConfig.glowstone);

    public static Flower flowerCoal = new Flower(Blocks.coal_block, "coal", () -> FlowerConfig.coalProbability, () -> FlowerConfig.coalCount);
    public static Flower flowerDiamond = new Flower(Blocks.diamond_block, "diamond", () -> FlowerConfig.diamondProbability, () -> FlowerConfig.diamondCount);
    public static Flower flowerEmerald = new Flower(Blocks.emerald_block, "emerald", () -> FlowerConfig.emeraldProbability, () -> FlowerConfig.emeraldCount);
    public static Flower flowerGold = new Flower(Blocks.gold_block, "gold", () -> FlowerConfig.goldProbability, () -> FlowerConfig.goldCount);
    public static Flower flowerIron = new Flower(Blocks.iron_block, "iron", () -> FlowerConfig.ironProbability, () -> FlowerConfig.ironCount);
    public static Flower flowerLapis = new Flower(Blocks.lapis_block, "lapis", () -> FlowerConfig.lapisProbability, () -> FlowerConfig.lapisCount);
    public static Flower flowerRedstone = new Flower(Blocks.redstone_block, "redstone", () -> FlowerConfig.redstoneProbability, () -> FlowerConfig.redstoneCount);
    public static Flower flowerQuartz = new Flower(Blocks.quartz_block, "quartz", () -> FlowerConfig.quartzProbability, () -> FlowerConfig.quartzCount);
    public static Flower flowerObsidian = new Flower(Blocks.obsidian, "obsidian", () -> FlowerConfig.obsidianProbability, () -> FlowerConfig.obsidianCount);
    public static Flower flowerGlowstone = new Flower(Blocks.glowstone, "glowstone", () -> FlowerConfig.glowstoneProbability, () -> FlowerConfig.glowstoneCount);
}
