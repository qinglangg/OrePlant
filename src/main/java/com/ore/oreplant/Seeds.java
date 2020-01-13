package com.ore.oreplant;

import com.ore.oreplant.generator.TreeGenerators;
import com.ore.oreplant.plants.Seed;
import com.ore.oreplant.plants.tree.Sapling;
import net.minecraft.item.Item;

public class Seeds {

    public static Item seedWheatCoal = new Seed(Crops.wheatCoal, "wheat_coal");
    public static Item seedWheatDiamond = new Seed(Crops.wheatDiamond, "wheat_diamond");
    public static Item seedWheatEmerald = new Seed(Crops.wheatEmerald, "wheat_emerald");
    public static Item seedWheatGold = new Seed(Crops.wheatGold, "wheat_gold");
    public static Item seedWheatIron = new Seed(Crops.wheatIron, "wheat_iron");
    public static Item seedWheatLapis = new Seed(Crops.wheatLapis, "wheat_lapis");
    public static Item seedWheatRedstone = new Seed(Crops.wheatRedstone, "wheat_redstone");
    public static Item seedWheatQuartz = new Seed(Crops.wheatQuartz, "wheat_quartz");
    public static Item seedWheatObsidian = new Seed(Crops.wheatObsidian, "wheat_obsidian");
    public static Item seedWheatGlowstone = new Seed(Crops.wheatGlowstone, "wheat_glowstone");

    public static Item seedPumpkinCoal = new Seed(Crops.pumpkinCoalStem, "pumpkin_coal");
    public static Item seedPumpkinDiamond = new Seed(Crops.pumpkinDiamondStem, "pumpkin_diamond");
    public static Item seedPumpkinEmerald = new Seed(Crops.pumpkinEmeraldStem, "pumpkin_emerald");
    public static Item seedPumpkinGold = new Seed(Crops.pumpkinGoldStem, "pumpkin_gold");
    public static Item seedPumpkinIron = new Seed(Crops.pumpkinIronStem, "pumpkin_iron");
    public static Item seedPumpkinLapis = new Seed(Crops.pumpkinLapisStem, "pumpkin_lapis");
    public static Item seedPumpkinRedstone = new Seed(Crops.pumpkinRedstoneStem, "pumpkin_redstone");
    public static Item seedPumpkinQuartz = new Seed(Crops.pumpkinQuartzStem, "pumpkin_quartz");
    public static Item seedPumpkinObsidian = new Seed(Crops.pumpkinObsidianStem, "pumpkin_obsidian");
    public static Item seedPumpkinGlowstone = new Seed(Crops.pumpkinGlowstoneStem, "pumpkin_glowstone");

    public static Sapling saplingCoal = new Sapling("coal", () -> new TreeGenerators(Crops.woodCoal, Crops.leafCoal, Seeds.saplingCoal));
    public static Sapling saplingDiamond = new Sapling("diamond", () -> new TreeGenerators(Crops.woodDiamond, Crops.leafDiamond, Seeds.saplingCoal));
    public static Sapling saplingEmerald = new Sapling("emerald", () -> new TreeGenerators(Crops.woodEmerald, Crops.leafEmerald, Seeds.saplingCoal));
    public static Sapling saplingGold = new Sapling("gold", () -> new TreeGenerators(Crops.woodGold, Crops.leafGold, Seeds.saplingCoal));
    public static Sapling saplingIron = new Sapling("iron", () -> new TreeGenerators(Crops.woodIron, Crops.leafIron, Seeds.saplingCoal));
    public static Sapling saplingLapis = new Sapling("lapis", () -> new TreeGenerators(Crops.woodLapis, Crops.leafLapis, Seeds.saplingCoal));
    public static Sapling saplingRedstone = new Sapling("redstone", () -> new TreeGenerators(Crops.woodRedstone, Crops.leafRedstone, Seeds.saplingCoal));
    public static Sapling saplingQuartz = new Sapling("quartz", () -> new TreeGenerators(Crops.woodQuartz, Crops.leafQuartz, Seeds.saplingCoal));
    public static Sapling saplingObsidian = new Sapling("obsidian", () -> new TreeGenerators(Crops.woodObsidian, Crops.leafObsidian, Seeds.saplingCoal));
    public static Sapling saplingGlowstone = new Sapling("glowstone", () -> new TreeGenerators(Crops.woodGlowstone, Crops.leafGlowstone, Seeds.saplingGlowstone));
}
