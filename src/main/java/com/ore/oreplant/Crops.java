package com.ore.oreplant;

import com.elementtimes.elementcore.api.annotation.ModBlock;
import com.ore.oreplant.annotation.SkipGroup;
import com.ore.oreplant.plants.PumpkinStem;
import com.ore.oreplant.plants.Wheat;
import com.ore.oreplant.plants.tree.Leaf;
import com.ore.oreplant.plants.tree.Wood;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockStem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Crops {

    @ModBlock
    @SkipGroup
    public static BlockCrops wheatCoal = new Wheat("coal", () -> new ItemStack(Items.coal), () -> new ItemStack(Seeds.seedWheatCoal));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatDiamond = new Wheat("diamond", () -> new ItemStack(Items.diamond),() -> new ItemStack(Seeds.seedWheatDiamond));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatEmerald = new Wheat("emerald", () -> new ItemStack(Items.emerald), () -> new ItemStack(Seeds.seedWheatEmerald));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatGold = new Wheat("gold", () -> new ItemStack(Items.gold_ingot), () -> new ItemStack(Seeds.seedWheatGold));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatIron = new Wheat("iron", () -> new ItemStack(Items.iron_ingot), () -> new ItemStack(Seeds.seedWheatIron));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatLapis = new Wheat("lapis", () -> new ItemStack(Items.dye, 1, 0), () -> new ItemStack(Seeds.seedWheatLapis));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatRedstone = new Wheat("redstone", () -> new ItemStack(Items.redstone), () -> new ItemStack(Seeds.seedWheatRedstone));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatQuartz = new Wheat("quartz", () -> new ItemStack(Items.quartz), () -> new ItemStack(Seeds.seedWheatQuartz));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatObsidian = new Wheat("obsidian", () -> new ItemStack(Blocks.obsidian), () -> new ItemStack(Seeds.seedWheatObsidian));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatGlowstone = new Wheat("glowstone", () -> new ItemStack(Items.glowstone_dust), () -> new ItemStack(Seeds.seedWheatGlowstone));

    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinCoalStem = new PumpkinStem(Blocks.coal_ore, Blocks.coal_ore, () -> Seeds.seedPumpkinCoal);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinDiamondStem = new PumpkinStem(Blocks.diamond_block, Blocks.diamond_ore, () -> Seeds.seedPumpkinDiamond);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinEmeraldStem = new PumpkinStem(Blocks.emerald_block, Blocks.emerald_ore, () -> Seeds.seedPumpkinEmerald);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinGoldStem = new PumpkinStem(Blocks.gold_block, Blocks.gold_ore, () -> Seeds.seedPumpkinGold);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinIronStem = new PumpkinStem(Blocks.iron_block, Blocks.iron_ore,() ->  Seeds.seedPumpkinIron);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinLapisStem = new PumpkinStem(Blocks.lapis_block, Blocks.lapis_ore, () -> Seeds.seedPumpkinLapis);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinRedstoneStem = new PumpkinStem(Blocks.redstone_block, Blocks.redstone_ore, () -> Seeds.seedPumpkinRedstone);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinQuartzStem = new PumpkinStem(Blocks.quartz_block, Blocks.quartz_ore, () -> Seeds.seedPumpkinQuartz);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinObsidianStem = new PumpkinStem(Blocks.obsidian, Blocks.obsidian, () -> Seeds.seedPumpkinObsidian);
    @ModBlock
    @SkipGroup
    public static BlockStem pumpkinGlowstoneStem = new PumpkinStem(Blocks.glowstone, Blocks.glowstone, () -> Seeds.seedPumpkinGlowstone);

    @ModBlock
    public static Wood woodCoal = new Wood("coal");
    @ModBlock
    public static Wood woodDiamond = new Wood("diamond");
    @ModBlock
    public static Wood woodEmerald = new Wood("emerald");
    @ModBlock
    public static Wood woodGold = new Wood("gold");
    @ModBlock
    public static Wood woodIron = new Wood("iron");
    @ModBlock
    public static Wood woodLapis = new Wood("lapis");
    @ModBlock
    public static Wood woodRedstone = new Wood("redstone");
    @ModBlock
    public static Wood woodQuartz = new Wood("quartz");
    @ModBlock
    public static Wood woodObsidian = new Wood("obsidian");
    @ModBlock
    public static Wood woodGlowstone = new Wood("glowstone");

    @ModBlock
    public static Leaf leafCoal = new Leaf(Blocks.coal_block, () -> Seeds.saplingCoal);
    @ModBlock
    public static Leaf leafDiamond = new Leaf(Blocks.diamond_block, () -> Seeds.saplingDiamond);
    @ModBlock
    public static Leaf leafEmerald = new Leaf(Blocks.emerald_block, () -> Seeds.saplingEmerald);
    @ModBlock
    public static Leaf leafGold = new Leaf(Blocks.gold_block, () -> Seeds.saplingGold);
    @ModBlock
    public static Leaf leafIron = new Leaf(Blocks.iron_block, () -> Seeds.saplingIron);
    @ModBlock
    public static Leaf leafLapis = new Leaf(Blocks.lapis_block, () -> Seeds.saplingLapis);
    @ModBlock
    public static Leaf leafRedstone = new Leaf(Blocks.redstone_block, () -> Seeds.saplingRedstone);
    @ModBlock
    public static Leaf leafQuartz = new Leaf(Blocks.quartz_block, () -> Seeds.saplingQuartz);
    @ModBlock
    public static Leaf leafObsidian = new Leaf(Blocks.obsidian, () -> Seeds.saplingObsidian);
    @ModBlock
    public static Leaf leafGlowstone = new Leaf(Blocks.glowstone, () -> Seeds.saplingGlowstone);
}
