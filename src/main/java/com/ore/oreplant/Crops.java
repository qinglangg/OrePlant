package com.ore.oreplant;

import com.ore.oreplant.config.Configuration;
import com.ore.oreplant.plants.Flower;
import com.ore.oreplant.plants.PumpkinStem;
import com.ore.oreplant.plants.Reeds;
import com.ore.oreplant.plants.Wheat;
import com.ore.oreplant.plants.tree.Leaf;
import com.ore.oreplant.plants.tree.Wood;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockStem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * 所有植物
 * @author luqin2007
 */
@SuppressWarnings("WeakerAccess")
public class Crops {

    public static BlockCrops wheatCoal = new Wheat(() -> new ItemStack(Seeds.seedWheatCoal), () -> new ItemStack(Items.COAL));
    public static BlockCrops wheatDiamond = new Wheat(() -> new ItemStack(Seeds.seedWheatDiamond), () -> new ItemStack(Items.DIAMOND));
    public static BlockCrops wheatEmerald = new Wheat(() -> new ItemStack(Seeds.seedWheatEmerald), () -> new ItemStack(Items.EMERALD));
    public static BlockCrops wheatGold = new Wheat(() -> new ItemStack(Seeds.seedWheatGold), () -> new ItemStack(Items.GOLD_INGOT));
    public static BlockCrops wheatIron = new Wheat(() -> new ItemStack(Seeds.seedWheatIron), () -> new ItemStack(Items.IRON_INGOT));
    public static BlockCrops wheatLapis = new Wheat(() -> new ItemStack(Seeds.seedWheatLapis), () -> new ItemStack(Items.DYE, 1, 4));
    public static BlockCrops wheatRedstone = new Wheat(() -> new ItemStack(Seeds.seedWheatRedstone), () -> new ItemStack(Items.REDSTONE));
    public static BlockCrops wheatQuartz = new Wheat(() -> new ItemStack(Seeds.seedWheatQuartz), () -> new ItemStack(Items.QUARTZ));
    public static BlockCrops wheatObsidian = new Wheat(() -> new ItemStack(Seeds.seedWheatObsidian), () -> new ItemStack(Blocks.OBSIDIAN));
    public static BlockCrops wheatGlowstone = new Wheat(() -> new ItemStack(Seeds.seedWheatGlowstone), () -> new ItemStack(Items.GLOWSTONE_DUST));

    public static BlockStem pumpkinCoalStem = new PumpkinStem(Blocks.COAL_ORE, Blocks.COAL_ORE, () -> Seeds.seedPumpkinCoal);
    public static BlockStem pumpkinDiamondStem = new PumpkinStem(Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, () -> Seeds.seedPumpkinDiamond);
    public static BlockStem pumpkinEmeraldStem = new PumpkinStem(Blocks.EMERALD_BLOCK, Blocks.EMERALD_ORE, () -> Seeds.seedPumpkinEmerald);
    public static BlockStem pumpkinGoldStem = new PumpkinStem(Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, () -> Seeds.seedPumpkinGold);
    public static BlockStem pumpkinIronStem = new PumpkinStem(Blocks.IRON_BLOCK, Blocks.IRON_ORE,() ->  Seeds.seedPumpkinIron);
    public static BlockStem pumpkinLapisStem = new PumpkinStem(Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, () -> Seeds.seedPumpkinLapis);
    public static BlockStem pumpkinRedstoneStem = new PumpkinStem(Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_ORE, () -> Seeds.seedPumpkinRedstone);
    public static BlockStem pumpkinQuartzStem = new PumpkinStem(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_ORE, () -> Seeds.seedPumpkinQuartz);
    public static BlockStem pumpkinObsidianStem = new PumpkinStem(Blocks.OBSIDIAN, Blocks.OBSIDIAN, () -> Seeds.seedPumpkinObsidian);
    public static BlockStem pumpkinGlowstoneStem = new PumpkinStem(Blocks.GLOWSTONE, Blocks.GLOWSTONE, () -> Seeds.seedPumpkinGlowstone);

    public static Wood woodCoal = new Wood(Blocks.COAL_BLOCK);
    public static Wood woodDiamond = new Wood(Blocks.DIAMOND_BLOCK);
    public static Wood woodEmerald = new Wood(Blocks.EMERALD_BLOCK);
    public static Wood woodGold = new Wood(Blocks.GOLD_BLOCK);
    public static Wood woodIron = new Wood(Blocks.IRON_BLOCK);
    public static Wood woodLapis = new Wood(Blocks.LAPIS_BLOCK);
    public static Wood woodRedstone = new Wood(Blocks.REDSTONE_BLOCK);
    public static Wood woodQuartz = new Wood(Blocks.QUARTZ_BLOCK);
    public static Wood woodObsidian = new Wood(Blocks.OBSIDIAN);
    public static Wood woodGlowstone = new Wood(Blocks.GLOWSTONE);

    public static Leaf leafCoal = new Leaf(Blocks.COAL_BLOCK, () -> Seeds.saplingCoal);
    public static Leaf leafDiamond = new Leaf(Blocks.DIAMOND_BLOCK, () -> Seeds.saplingDiamond);
    public static Leaf leafEmerald = new Leaf(Blocks.EMERALD_BLOCK, () -> Seeds.saplingEmerald);
    public static Leaf leafGold = new Leaf(Blocks.GOLD_BLOCK, () -> Seeds.saplingGold);
    public static Leaf leafIron = new Leaf(Blocks.IRON_BLOCK, () -> Seeds.saplingIron);
    public static Leaf leafLapis = new Leaf(Blocks.LAPIS_BLOCK, () -> Seeds.saplingLapis);
    public static Leaf leafRedstone = new Leaf(Blocks.REDSTONE_BLOCK, () -> Seeds.saplingRedstone);
    public static Leaf leafQuartz = new Leaf(Blocks.QUARTZ_BLOCK, () -> Seeds.saplingQuartz);
    public static Leaf leafObsidian = new Leaf(Blocks.OBSIDIAN, () -> Seeds.saplingObsidian);
    public static Leaf leafGlowstone = new Leaf(Blocks.GLOWSTONE, () -> Seeds.saplingGlowstone);

    public static Flower flowerCoal = new Flower(Blocks.COAL_BLOCK, () -> Configuration.flower.coalProbability, () -> Configuration.flower.coalCount);
    public static Flower flowerDiamond = new Flower(Blocks.DIAMOND_BLOCK, () -> Configuration.flower.diamondProbability, () -> Configuration.flower.diamondCount);
    public static Flower flowerEmerald = new Flower(Blocks.EMERALD_BLOCK, () -> Configuration.flower.emeraldProbability, () -> Configuration.flower.emeraldCount);
    public static Flower flowerGold = new Flower(Blocks.GOLD_BLOCK, () -> Configuration.flower.goldProbability, () -> Configuration.flower.goldCount);
    public static Flower flowerIron = new Flower(Blocks.IRON_BLOCK, () -> Configuration.flower.ironProbability, () -> Configuration.flower.ironCount);
    public static Flower flowerLapis = new Flower(Blocks.LAPIS_BLOCK, () -> Configuration.flower.lapisProbability, () -> Configuration.flower.lapisCount);
    public static Flower flowerRedstone = new Flower(Blocks.REDSTONE_BLOCK, () -> Configuration.flower.redstoneProbability, () -> Configuration.flower.redstoneCount);
    public static Flower flowerQuartz = new Flower(Blocks.QUARTZ_BLOCK, () -> Configuration.flower.quartzProbability, () -> Configuration.flower.quartzCount);
    public static Flower flowerObsidian = new Flower(Blocks.OBSIDIAN, () -> Configuration.flower.obsidianProbability, () -> Configuration.flower.obsidianCount);
    public static Flower flowerGlowstone = new Flower(Blocks.GLOWSTONE, () -> Configuration.flower.glowstoneProbability, () -> Configuration.flower.glowstoneCount);

    public static BlockReed reedCoal = new Reeds(Blocks.COAL_ORE, () -> Configuration.reed.coal);
    public static BlockReed reedDiamond = new Reeds(Blocks.DIAMOND_BLOCK, () -> Configuration.reed.diamond);
    public static BlockReed reedEmerald = new Reeds(Blocks.EMERALD_BLOCK, () -> Configuration.reed.emerald);
    public static BlockReed reedGold = new Reeds(Blocks.GOLD_BLOCK, () -> Configuration.reed.gold);
    public static BlockReed reedIron = new Reeds(Blocks.IRON_BLOCK, () -> Configuration.reed.iron);
    public static BlockReed reedLapis = new Reeds(Blocks.LAPIS_BLOCK, () -> Configuration.reed.lapis);
    public static BlockReed reedRedstone = new Reeds(Blocks.REDSTONE_BLOCK, () -> Configuration.reed.redstone);
    public static BlockReed reedQuartz = new Reeds(Blocks.QUARTZ_BLOCK, () -> Configuration.reed.quartz);
    public static BlockReed reedObsidian = new Reeds(Blocks.OBSIDIAN, () -> Configuration.reed.obsidian);
    public static BlockReed reedGlowstone = new Reeds(Blocks.GLOWSTONE, () -> Configuration.reed.glowstone);
}
