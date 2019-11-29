package com.ore.oreplant;

import com.elementtimes.elementcore.api.annotation.ModBlock;
import com.elementtimes.elementcore.api.annotation.ModItem;
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

    @ModItem
    public static Item seedWheatCoal = new Seed(Crops.wheatCoal);
    @ModItem
    public static Item seedWheatDiamond = new Seed(Crops.wheatDiamond);
    @ModItem
    public static Item seedWheatEmerald = new Seed(Crops.wheatEmerald);
    @ModItem
    public static Item seedWheatGold = new Seed(Crops.wheatGold);
    @ModItem
    public static Item seedWheatIron = new Seed(Crops.wheatIron);
    @ModItem
    public static Item seedWheatLapis = new Seed(Crops.wheatLapis);
    @ModItem
    public static Item seedWheatRedstone = new Seed(Crops.wheatRedstone);
    @ModItem
    public static Item seedWheatQuartz = new Seed(Crops.wheatQuartz);
    @ModItem
    public static Item seedWheatObsidian = new Seed(Crops.wheatObsidian);
    @ModItem
    public static Item seedWheatGlowstone = new Seed(Crops.wheatGlowstone);

    @ModItem
    public static Item seedPumpkinCoal = new Seed(Crops.pumpkinCoalStem);
    @ModItem
    public static Item seedPumpkinDiamond = new Seed(Crops.pumpkinDiamondStem);
    @ModItem
    public static Item seedPumpkinEmerald = new Seed(Crops.pumpkinEmeraldStem);
    @ModItem
    public static Item seedPumpkinGold = new Seed(Crops.pumpkinGoldStem);
    @ModItem
    public static Item seedPumpkinIron = new Seed(Crops.pumpkinIronStem);
    @ModItem
    public static Item seedPumpkinLapis = new Seed(Crops.pumpkinLapisStem);
    @ModItem
    public static Item seedPumpkinRedstone = new Seed(Crops.pumpkinRedstoneStem);
    @ModItem
    public static Item seedPumpkinQuartz = new Seed(Crops.pumpkinQuartzStem);
    @ModItem
    public static Item seedPumpkinObsidian = new Seed(Crops.pumpkinObsidianStem);
    @ModItem
    public static Item seedPumpkinGlowstone = new Seed(Crops.pumpkinGlowstoneStem);

    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingCoal = new Sapling(() -> new TreeGenerators(Crops.woodCoal, Crops.leafCoal));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingIron = new Sapling(() -> new TreeGenerators(Crops.woodIron, Crops.leafIron));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingRedstone = new Sapling(() -> new TreeGenerators(Crops.woodRedstone, Crops.leafRedstone));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingGold = new Sapling(() -> new TreeGenerators(Crops.woodGold, Crops.leafGold));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingQuartz = new Sapling(() -> new TreeGenerators(Crops.woodQuartz, Crops.leafQuartz));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingObsidian = new Sapling(() -> new TreeGenerators(Crops.woodObsidian, Crops.leafObsidian));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingGlowstone = new Sapling(() -> new TreeGenerators(Crops.woodGlowstone, Crops.leafGlowstone));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingLapis = new Sapling(() -> new TreeGenerators(Crops.woodLapis, Crops.leafLapis));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingDiamond = new Sapling(() -> new TreeGenerators(Crops.woodDiamond, Crops.leafDiamond));
    @ModBlock
    @ModBlock.StateMapperCustom("com.ore.oreplant.render.SaplingMap")
    public static Sapling saplingEmerald = new Sapling(() -> new TreeGenerators(Crops.woodEmerald, Crops.leafEmerald));
}
