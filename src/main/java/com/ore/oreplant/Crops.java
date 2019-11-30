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

import java.util.Arrays;

/**
 * 所有植物
 * @author luqin2007
 */
@SuppressWarnings("WeakerAccess")
public class Crops {

    @ModBlock
    @SkipGroup
    public static BlockCrops wheatCoal = new Wheat(() -> new ItemStack(Seeds.seedWheatCoal), () -> new ItemStack(Items.COAL));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatDiamond = new Wheat(() -> new ItemStack(Seeds.seedWheatDiamond), () -> new ItemStack(Items.DIAMOND));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatEmerald = new Wheat(() -> new ItemStack(Seeds.seedWheatEmerald), () -> new ItemStack(Items.EMERALD));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatGold = new Wheat(() -> new ItemStack(Seeds.seedWheatGold), () -> new ItemStack(Items.GOLD_INGOT));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatIron = new Wheat(() -> new ItemStack(Seeds.seedWheatIron), () -> new ItemStack(Items.IRON_INGOT));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatLapis = new Wheat(() -> new ItemStack(Seeds.seedWheatLapis), () -> new ItemStack(Items.DYE, 1, 4));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatRedstone = new Wheat(() -> new ItemStack(Seeds.seedWheatRedstone), () -> new ItemStack(Items.REDSTONE));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatQuartz = new Wheat(() -> new ItemStack(Seeds.seedWheatQuartz), () -> new ItemStack(Items.QUARTZ));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatObsidian = new Wheat(() -> new ItemStack(Seeds.seedWheatObsidian), () -> new ItemStack(Blocks.OBSIDIAN));
    @ModBlock
    @SkipGroup
    public static BlockCrops wheatGlowstone = new Wheat(() -> new ItemStack(Seeds.seedWheatGlowstone), () -> new ItemStack(Items.GLOWSTONE_DUST));

    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinCoalStem = new PumpkinStem(Blocks.COAL_ORE, Blocks.COAL_ORE, () -> Seeds.seedPumpkinCoal);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinDiamondStem = new PumpkinStem(Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, () -> Seeds.seedPumpkinDiamond);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinEmeraldStem = new PumpkinStem(Blocks.EMERALD_BLOCK, Blocks.EMERALD_ORE, () -> Seeds.seedPumpkinEmerald);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinGoldStem = new PumpkinStem(Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, () -> Seeds.seedPumpkinGold);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinIronStem = new PumpkinStem(Blocks.IRON_BLOCK, Blocks.IRON_ORE,() ->  Seeds.seedPumpkinIron);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinLapisStem = new PumpkinStem(Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, () -> Seeds.seedPumpkinLapis);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinRedstoneStem = new PumpkinStem(Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_ORE, () -> Seeds.seedPumpkinRedstone);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinQuartzStem = new PumpkinStem(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_ORE, () -> Seeds.seedPumpkinQuartz);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinObsidianStem = new PumpkinStem(Blocks.OBSIDIAN, Blocks.OBSIDIAN, () -> Seeds.seedPumpkinObsidian);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.PumpkinStemMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    @SkipGroup
    public static BlockStem pumpkinGlowstoneStem = new PumpkinStem(Blocks.GLOWSTONE, Blocks.GLOWSTONE, () -> Seeds.seedPumpkinGlowstone);

    @ModBlock
    public static Wood woodCoal = new Wood(Blocks.COAL_BLOCK);
    @ModBlock
    public static Wood woodDiamond = new Wood(Blocks.DIAMOND_BLOCK);
    @ModBlock
    public static Wood woodEmerald = new Wood(Blocks.EMERALD_BLOCK);
    @ModBlock
    public static Wood woodGold = new Wood(Blocks.GOLD_BLOCK);
    @ModBlock
    public static Wood woodIron = new Wood(Blocks.IRON_BLOCK);
    @ModBlock
    public static Wood woodLapis = new Wood(Blocks.LAPIS_BLOCK);
    @ModBlock
    public static Wood woodRedstone = new Wood(Blocks.REDSTONE_BLOCK);
    @ModBlock
    public static Wood woodQuartz = new Wood(Blocks.QUARTZ_BLOCK);
    @ModBlock
    public static Wood woodObsidian = new Wood(Blocks.OBSIDIAN);
    @ModBlock
    public static Wood woodGlowstone = new Wood(Blocks.GLOWSTONE);

    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafCoal = new Leaf(Blocks.COAL_BLOCK, () -> Seeds.saplingCoal);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafDiamond = new Leaf(Blocks.DIAMOND_BLOCK, () -> Seeds.saplingDiamond);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafEmerald = new Leaf(Blocks.EMERALD_BLOCK, () -> Seeds.saplingEmerald);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafGold = new Leaf(Blocks.GOLD_BLOCK, () -> Seeds.saplingGold);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafIron = new Leaf(Blocks.IRON_BLOCK, () -> Seeds.saplingIron);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafLapis = new Leaf(Blocks.LAPIS_BLOCK, () -> Seeds.saplingLapis);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafRedstone = new Leaf(Blocks.REDSTONE_BLOCK, () -> Seeds.saplingRedstone);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafQuartz = new Leaf(Blocks.QUARTZ_BLOCK, () -> Seeds.saplingQuartz);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafObsidian = new Leaf(Blocks.OBSIDIAN, () -> Seeds.saplingObsidian);
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.LeafMap")
    @ModBlock.BlockColor(value = "com.ore.oreplant.render.PlantColorRender", itemColor = "com.ore.oreplant.render.PlantColorRender")
    public static Leaf leafGlowstone = new Leaf(Blocks.GLOWSTONE, () -> Seeds.saplingGlowstone);
}
