package com.ore.oreplant;

import com.elementtimes.elementcore.api.annotation.ModBlock;
import com.elementtimes.elementcore.api.annotation.ModItem;
import com.ore.oreplant.generator.TreeGenerators;
import com.ore.oreplant.plants.Seed;
import com.ore.oreplant.plants.tree.Sapling;
import net.minecraft.item.Item;

public class Seeds {

    @ModItem
    public static Item seedWheatCoal = new Seed(Crops.wheatCoal, "wheat_coal");
    @ModItem
    public static Item seedWheatDiamond = new Seed(Crops.wheatDiamond, "wheat_diamond");
    @ModItem
    public static Item seedWheatEmerald = new Seed(Crops.wheatEmerald, "wheat_emerald");
    @ModItem
    public static Item seedWheatGold = new Seed(Crops.wheatGold, "wheat_gold");
    @ModItem
    public static Item seedWheatIron = new Seed(Crops.wheatIron, "wheat_iron");
    @ModItem
    public static Item seedWheatLapis = new Seed(Crops.wheatLapis, "wheat_lapis");
    @ModItem
    public static Item seedWheatRedstone = new Seed(Crops.wheatRedstone, "wheat_redstone");
    @ModItem
    public static Item seedWheatQuartz = new Seed(Crops.wheatQuartz, "wheat_quartz");
    @ModItem
    public static Item seedWheatObsidian = new Seed(Crops.wheatObsidian, "wheat_obsidian");
    @ModItem
    public static Item seedWheatGlowstone = new Seed(Crops.wheatGlowstone, "wheat_glowstone");

    @ModItem
    public static Item seedPumpkinCoal = new Seed(Crops.pumpkinCoalStem, "pumpkin_coal");
    @ModItem
    public static Item seedPumpkinDiamond = new Seed(Crops.pumpkinDiamondStem, "pumpkin_diamond");
    @ModItem
    public static Item seedPumpkinEmerald = new Seed(Crops.pumpkinEmeraldStem, "pumpkin_emerald");
    @ModItem
    public static Item seedPumpkinGold = new Seed(Crops.pumpkinGoldStem, "pumpkin_gold");
    @ModItem
    public static Item seedPumpkinIron = new Seed(Crops.pumpkinIronStem, "pumpkin_iron");
    @ModItem
    public static Item seedPumpkinLapis = new Seed(Crops.pumpkinLapisStem, "pumpkin_lapis");
    @ModItem
    public static Item seedPumpkinRedstone = new Seed(Crops.pumpkinRedstoneStem, "pumpkin_redstone");
    @ModItem
    public static Item seedPumpkinQuartz = new Seed(Crops.pumpkinQuartzStem, "pumpkin_quartz");
    @ModItem
    public static Item seedPumpkinObsidian = new Seed(Crops.pumpkinObsidianStem, "pumpkin_obsidian");
    @ModItem
    public static Item seedPumpkinGlowstone = new Seed(Crops.pumpkinGlowstoneStem, "pumpkin_glowstone");

    @ModBlock
    public static Sapling saplingCoal = new Sapling("coal", () -> new TreeGenerators(Crops.woodCoal, Crops.leafCoal, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingDiamond = new Sapling("diamond", () -> new TreeGenerators(Crops.woodDiamond, Crops.leafDiamond, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingEmerald = new Sapling("emerald", () -> new TreeGenerators(Crops.woodEmerald, Crops.leafEmerald, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingGold = new Sapling("gold", () -> new TreeGenerators(Crops.woodGold, Crops.leafGold, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingIron = new Sapling("iron", () -> new TreeGenerators(Crops.woodIron, Crops.leafIron, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingLapis = new Sapling("lapis", () -> new TreeGenerators(Crops.woodLapis, Crops.leafLapis, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingRedstone = new Sapling("redstone", () -> new TreeGenerators(Crops.woodRedstone, Crops.leafRedstone, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingQuartz = new Sapling("quartz", () -> new TreeGenerators(Crops.woodQuartz, Crops.leafQuartz, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingObsidian = new Sapling("obsidian", () -> new TreeGenerators(Crops.woodObsidian, Crops.leafObsidian, Seeds.saplingCoal));
    @ModBlock
    public static Sapling saplingGlowstone = new Sapling("glowstone", () -> new TreeGenerators(Crops.woodGlowstone, Crops.leafGlowstone, Seeds.saplingGlowstone));
}
