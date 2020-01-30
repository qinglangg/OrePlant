package com.ore.oreplant;

import com.ore.oreplant.config.TreeConfig;
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

    public static Sapling saplingCoal = new Sapling("coal", () -> Crops.woodCoal, () -> Crops.leafCoal, () -> TreeConfig.coal);
    public static Sapling saplingDiamond = new Sapling("diamond", () -> Crops.woodDiamond, () -> Crops.leafDiamond, () -> TreeConfig.diamond);
    public static Sapling saplingEmerald = new Sapling("emerald", () -> Crops.woodEmerald, () -> Crops.leafEmerald, () -> TreeConfig.emerald);
    public static Sapling saplingGold = new Sapling("gold", () -> Crops.woodGold, () -> Crops.leafGold, () -> TreeConfig.gold);
    public static Sapling saplingIron = new Sapling("iron", () -> Crops.woodIron, () -> Crops.leafIron, () -> TreeConfig.iron);
    public static Sapling saplingLapis = new Sapling("lapis", () -> Crops.woodLapis, () -> Crops.leafLapis, () -> TreeConfig.lapis);
    public static Sapling saplingRedstone = new Sapling("redstone", () -> Crops.woodRedstone, () -> Crops.leafRedstone, () -> TreeConfig.redstone);
    public static Sapling saplingQuartz = new Sapling("quartz", () -> Crops.woodQuartz, () -> Crops.leafQuartz, () -> TreeConfig.quartz);
    public static Sapling saplingObsidian = new Sapling("obsidian", () -> Crops.woodObsidian, () -> Crops.leafObsidian, () -> TreeConfig.obsidian);
    public static Sapling saplingGlowstone = new Sapling("glowstone", () -> Crops.woodGlowstone, () -> Crops.leafGlowstone, () -> TreeConfig.glowstone);
}
