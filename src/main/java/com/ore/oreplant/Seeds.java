package com.ore.oreplant;

import com.elementtimes.elementcore.api.annotation.ModBlock;
import com.elementtimes.elementcore.api.annotation.ModItem;
import com.ore.oreplant.generator.RubberGenerator;
import com.ore.oreplant.plants.tree.Sapling;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class Seeds {

    @ModItem
    public static Item seedWheatCoal = new ItemSeeds(Crops.wheatCoal, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedWheatDiamond = new ItemSeeds(Crops.wheatDiamond, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedWheatEmerald = new ItemSeeds(Crops.wheatEmerald, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedWheatGold = new ItemSeeds(Crops.wheatGold, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedWheatIron = new ItemSeeds(Crops.wheatIron, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedWheatLapis = new ItemSeeds(Crops.wheatLapis, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedWheatRedstone = new ItemSeeds(Crops.wheatRedstone, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);

    @ModItem
    public static Item seedPumpkinCoal = new ItemSeeds(Crops.pumpkinCoalStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedPumpkinDiamond = new ItemSeeds(Crops.pumpkinDiamondStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedPumpkinEmerald = new ItemSeeds(Crops.pumpkinEmeraldStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedPumpkinGold = new ItemSeeds(Crops.pumpkinGoldStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedPumpkinIron = new ItemSeeds(Crops.pumpkinIronStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedPumpkinLapis = new ItemSeeds(Crops.pumpkinLapisStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);
    @ModItem
    public static Item seedPumpkinRedstone = new ItemSeeds(Crops.pumpkinRedstoneStem, Blocks.FARMLAND).setCreativeTab(OreTabs.TAB);

    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingCoal = new Sapling(() -> new RubberGenerator(false, Crops.woodCoal, Crops.leafCoal));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingDiamond = new Sapling(() -> new RubberGenerator(false, Crops.woodDiamond, Crops.leafDiamond));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingEmerald = new Sapling(() -> new RubberGenerator(false, Crops.woodEmerald, Crops.leafEmerald));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingGold = new Sapling(() -> new RubberGenerator(false, Crops.woodGold, Crops.leafGold));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingIron = new Sapling(() -> new RubberGenerator(false, Crops.woodIron, Crops.leafIron));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingLapis = new Sapling(() -> new RubberGenerator(false, Crops.woodLapis, Crops.leafLapis));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingRedstone = new Sapling(() -> new RubberGenerator(false, Crops.woodRedstone, Crops.leafRedstone));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingQuartz = new Sapling(() -> new RubberGenerator(false, Crops.woodQuartz, Crops.leafQuartz));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingObsidian = new Sapling(() -> new RubberGenerator(false, Crops.woodObsidian, Crops.leafObsidian));
}
