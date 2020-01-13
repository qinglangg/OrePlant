package com.ore.oreplant;

import com.ore.oreplant.generator.TreeGenerators;
import com.ore.oreplant.plants.Seed;
import com.ore.oreplant.plants.tree.Sapling;
import net.minecraft.item.Item;

/**
 * 所有种子/树苗等
 * @author luqin2007
 */
@SuppressWarnings("WeakerAccess")
public class Seeds {

    public static Item seedWheatCoal = new Seed(Crops.wheatCoal);
    public static Item seedWheatDiamond = new Seed(Crops.wheatDiamond);
    public static Item seedWheatEmerald = new Seed(Crops.wheatEmerald);
    public static Item seedWheatGold = new Seed(Crops.wheatGold);
    public static Item seedWheatIron = new Seed(Crops.wheatIron);
    public static Item seedWheatLapis = new Seed(Crops.wheatLapis);
    public static Item seedWheatRedstone = new Seed(Crops.wheatRedstone);
    public static Item seedWheatQuartz = new Seed(Crops.wheatQuartz);
    public static Item seedWheatObsidian = new Seed(Crops.wheatObsidian);
    public static Item seedWheatGlowstone = new Seed(Crops.wheatGlowstone);

    public static Item seedPumpkinCoal = new Seed(Crops.pumpkinCoalStem);
    public static Item seedPumpkinDiamond = new Seed(Crops.pumpkinDiamondStem);
    public static Item seedPumpkinEmerald = new Seed(Crops.pumpkinEmeraldStem);
    public static Item seedPumpkinGold = new Seed(Crops.pumpkinGoldStem);
    public static Item seedPumpkinIron = new Seed(Crops.pumpkinIronStem);
    public static Item seedPumpkinLapis = new Seed(Crops.pumpkinLapisStem);
    public static Item seedPumpkinRedstone = new Seed(Crops.pumpkinRedstoneStem);
    public static Item seedPumpkinQuartz = new Seed(Crops.pumpkinQuartzStem);
    public static Item seedPumpkinObsidian = new Seed(Crops.pumpkinObsidianStem);
    public static Item seedPumpkinGlowstone = new Seed(Crops.pumpkinGlowstoneStem);

    public static Sapling saplingCoal = new Sapling(() -> new TreeGenerators(Crops.woodCoal, Crops.leafCoal));
    public static Sapling saplingIron = new Sapling(() -> new TreeGenerators(Crops.woodIron, Crops.leafIron));
    public static Sapling saplingRedstone = new Sapling(() -> new TreeGenerators(Crops.woodRedstone, Crops.leafRedstone));
    public static Sapling saplingGold = new Sapling(() -> new TreeGenerators(Crops.woodGold, Crops.leafGold));
    public static Sapling saplingQuartz = new Sapling(() -> new TreeGenerators(Crops.woodQuartz, Crops.leafQuartz));
    public static Sapling saplingObsidian = new Sapling(() -> new TreeGenerators(Crops.woodObsidian, Crops.leafObsidian));
    public static Sapling saplingGlowstone = new Sapling(() -> new TreeGenerators(Crops.woodGlowstone, Crops.leafGlowstone));
    public static Sapling saplingLapis = new Sapling(() -> new TreeGenerators(Crops.woodLapis, Crops.leafLapis));
    public static Sapling saplingDiamond = new Sapling(() -> new TreeGenerators(Crops.woodDiamond, Crops.leafDiamond));
    public static Sapling saplingEmerald = new Sapling(() -> new TreeGenerators(Crops.woodEmerald, Crops.leafEmerald));
}
