package com.ore.oreplant.config;

import com.ore.oreplant.Seeds;
import com.ore.oreplant.generator.TreeGenerator;
import com.ore.oreplant.generator.TreeGenerators;
import com.ore.oreplant.plants.tree.Sapling;
import net.minecraftforge.common.config.Configuration;

import java.util.function.DoubleSupplier;

/**
 * 配置
 * @author luqin2007
 */
public class TreeConfig {
    public static boolean generate = true;
    public static double      coal = 0.003;
    public static double      iron = 0.002;
    public static double  redstone = 0.001;
    public static double      gold = 0.001;
    public static double    quartz = 0.001;
    public static double  obsidian = 0.001;
    public static double glowstone = 0.001;
    public static double     lapis = 0.0005;
    public static double   diamond = 0.0001;
    public static double   emerald = 0.0001;

    public static void load(Configuration config) {
         generate = config.get("tree", "generate", true, "Natural Generate").getBoolean();
             coal = config.get("tree",      "coal", 0.030,      "Coal Tree Probability").getDouble();
             iron = config.get("tree",      "iron", 0.020,      "Iron Tree Probability").getDouble();
         redstone = config.get("tree",  "redstone", 0.010,  "Redstone Tree Probability").getDouble();
             gold = config.get("tree",      "gold", 0.010,      "Gold Tree Probability").getDouble();
           quartz = config.get("tree",    "quartz", 0.010,    "Quartz Tree Probability").getDouble();
         obsidian = config.get("tree",  "obsidian", 0.010,  "Obsidian Tree Probability").getDouble();
        glowstone = config.get("tree", "glowstone", 0.010, "Glowstone Tree Probability").getDouble();
            lapis = config.get("tree",     "lapis", 0.005,     "Lapis Tree Probability").getDouble();
          diamond = config.get("tree",   "diamond", 0.001,   "Diamond Tree Probability").getDouble();
          emerald = config.get("tree",   "emerald", 0.001,   "Emerald Tree Probability").getDouble();

        setDecorator(Seeds.saplingCoal, () -> TreeConfig.coal);
        setDecorator(Seeds.saplingDiamond, () -> TreeConfig.diamond);
        setDecorator(Seeds.saplingEmerald, () -> TreeConfig.emerald);
        setDecorator(Seeds.saplingGlowstone, () -> TreeConfig.glowstone);
        setDecorator(Seeds.saplingGold, () -> TreeConfig.gold);
        setDecorator(Seeds.saplingIron, () -> TreeConfig.iron);
        setDecorator(Seeds.saplingLapis, () -> TreeConfig.lapis);
        setDecorator(Seeds.saplingObsidian, () -> TreeConfig.obsidian);
        setDecorator(Seeds.saplingQuartz, () -> TreeConfig.quartz);
        setDecorator(Seeds.saplingRedstone, () -> TreeConfig.redstone);
    }

    private static void setDecorator(Sapling sapling, DoubleSupplier probabilityGetter) {
        TreeGenerators generators = sapling.getGenerators();
        generators.setCanGenerator(TreeConfig.generate);
        generators.setDecorator(new TreeGenerator(false, generators.wood, generators.leaf, generators.sapling, probabilityGetter));
    }
}
