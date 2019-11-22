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
    public static Item seedWheatCoal = new ItemSeeds(Crops.wheatCoal, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_coal");
    @ModItem
    public static Item seedWheatDiamond = new ItemSeeds(Crops.wheatDiamond, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_diamond");
    @ModItem
    public static Item seedWheatEmerald = new ItemSeeds(Crops.wheatEmerald, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_emerald");
    @ModItem
    public static Item seedWheatGold = new ItemSeeds(Crops.wheatGold, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_gold");
    @ModItem
    public static Item seedWheatIron = new ItemSeeds(Crops.wheatIron, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_iron");
    @ModItem
    public static Item seedWheatLapis = new ItemSeeds(Crops.wheatLapis, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_lapis");
    @ModItem
    public static Item seedWheatRedstone = new ItemSeeds(Crops.wheatRedstone, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:wheat_redstone");

    @ModItem
    public static Item seedPumpkinCoal = new ItemSeeds(Crops.pumpkinCoalStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_coal");
    @ModItem
    public static Item seedPumpkinDiamond = new ItemSeeds(Crops.pumpkinDiamondStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_diamond");
    @ModItem
    public static Item seedPumpkinEmerald = new ItemSeeds(Crops.pumpkinEmeraldStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_emerald");
    @ModItem
    public static Item seedPumpkinGold = new ItemSeeds(Crops.pumpkinGoldStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_gold");
    @ModItem
    public static Item seedPumpkinIron = new ItemSeeds(Crops.pumpkinIronStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_iron");
    @ModItem
    public static Item seedPumpkinLapis = new ItemSeeds(Crops.pumpkinLapisStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_lapis");
    @ModItem
    public static Item seedPumpkinRedstone = new ItemSeeds(Crops.pumpkinRedstoneStem, Blocks.farmland).setCreativeTab(OreTabs.TAB).setTextureName("oreplant:pumpkin_redstone");

    @ModBlock
    public static Sapling saplingCoal = new Sapling("coal", () -> new RubberGenerator(false, Crops.woodCoal, Crops.leafCoal, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingDiamond = new Sapling("diamond", () -> new RubberGenerator(false, Crops.woodDiamond, Crops.leafDiamond, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingEmerald = new Sapling("emerald", () -> new RubberGenerator(false, Crops.woodEmerald, Crops.leafEmerald, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingGold = new Sapling("gold", () -> new RubberGenerator(false, Crops.woodGold, Crops.leafGold, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingIron = new Sapling("iron", () -> new RubberGenerator(false, Crops.woodIron, Crops.leafIron, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingLapis = new Sapling("lapis", () -> new RubberGenerator(false, Crops.woodLapis, Crops.leafLapis, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingRedstone = new Sapling("redstone", () -> new RubberGenerator(false, Crops.woodRedstone, Crops.leafRedstone, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingQuartz = new Sapling("quartz", () -> new RubberGenerator(false, Crops.woodQuartz, Crops.leafQuartz, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingObsidian = new Sapling("obsidian", () -> new RubberGenerator(false, Crops.woodObsidian, Crops.leafObsidian, () -> Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingGlowstone = new Sapling("glowstone", () -> new RubberGenerator(false, Crops.woodGlowstone, Crops.leafGlowstone, () -> Seeds.saplingGlowstone));
}
